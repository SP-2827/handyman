package in.handyman.process.onethread

import java.io.BufferedReader
import java.io.DataOutputStream
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLConnection

import org.apache.http.HttpResponse
import org.apache.http.client.HttpClient
import org.apache.http.client.methods.HttpPost
import org.apache.http.entity.FileEntity
import org.apache.http.impl.client.DefaultHttpClient
import org.slf4j.Logger
import org.slf4j.Marker
import org.slf4j.MarkerFactory

import in.handyman.raven.lambda.action.ActionExecution
import in.handyman.raven.lambda.action.IActionExecution
import in.handyman.raven.lambda.doa.audit.ActionExecutionAudit
import in.handyman.raven.lib.model.SharePoint;

/**
 * Auto Generated By Raven
 */
@ActionExecution(
    actionName = "SharePoint"
)
class SharePointAction extends IActionExecution {
  var action : ActionExecutionAudit;
  var log : Logger;
  var sharePoint : SharePoint;
  var aMarker : Marker;
  
  def SharePointAction(action : ActionExecutionAudit, log : Logger, sharePoint : Object) {
    this.sharePoint = sharePoint.asInstanceOf[SharePoint];
    this.action = action;
    this.log = log;
    this.aMarker = MarkerFactory.getMarker(" SharePoint:"+this.sharePoint.getName());
  }
  
  @Override
  def execute() = {

    val clientId = sharePoint.getShpClientId
    val name = sharePoint.getName
    val tenantId = sharePoint.getShpTenantId
    val clientSecret = sharePoint.getShpClientSecret
    val orgName = sharePoint.getOrgName
    val actionType = sharePoint.getActionType
    val siteUrl = sharePoint.getSiteUrl
    val sourceRelativePath = sharePoint.getSourceRelativePath
    val targetRelativePath = sharePoint.getTargetRelativePath
    val fileName = sharePoint.getFileName
    
    val accessToken : String = getSharepointToken(orgName, clientId, clientSecret, tenantId)
    
    if(actionType == "upload")
      upload(accessToken, siteUrl, sourceRelativePath, targetRelativePath, fileName)
    else if(actionType =="download")
      download(accessToken, siteUrl, sourceRelativePath, targetRelativePath, fileName)
  }
  
	def getSharepointToken(orgName : String, clientId : String, clientSecret : String, tenantId : String) : String = {
		var accessToken : String = ""
		try {
			// AccessToken url
		    var wsURL : String = "https://accounts.accesscontrol.windows.net/"+tenantId+"/tokens/OAuth/2"

		    val url : URL = new URL(wsURL);
		    val connection : URLConnection = url.openConnection();
		    val httpConn : HttpURLConnection = connection.asInstanceOf[HttpURLConnection];

		    // Set header
		    httpConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		    httpConn.setDoOutput(true);
		    httpConn.setDoInput(true);
		    httpConn.setRequestMethod("POST");

		    var jsonParam : String = "grant_type=client_credentials&client_id="+clientId+"@"+tenantId+"&client_secret="+clientSecret+"&resource=00000003-0000-0ff1-ce00-000000000000/"+orgName+".sharepoint.com@"+tenantId

		    // Send Request
		    val wr : DataOutputStream = new DataOutputStream(httpConn.getOutputStream());
		    wr.writeBytes(jsonParam);
		    wr.flush();
		    wr.close();

		    // Read the response.
		    var isr : InputStreamReader = null;
		    if (httpConn.getResponseCode() == 200) {
		        isr = new InputStreamReader(httpConn.getInputStream());
		    } else {
		        isr = new InputStreamReader(httpConn.getErrorStream());
		    }

		    val in : BufferedReader = new BufferedReader(isr);
		    var responseString : String = "";
		    var outputString : String = "";

		    // Write response to a String.
		    while ({responseString = in.readLine; responseString != null}) {
          outputString = outputString + responseString;
        }
		    //System.out.println(outputString);
		    
		    // Extracting accessToken from string, here response
		    // (outputString)is a Json format string
		    if (outputString.indexOf("access_token\":\"") > -1) {
		        val i1 : Int = outputString.indexOf("access_token\":\"");
		        val str1 : String = outputString.substring(i1 + 15);
		        val i2 : Int = str1.indexOf("\"}");
		        val str2 : String = str1.substring(0, i2);
		        accessToken = str2;
		        //System.out.println("accessToken.........." + accessToken);
		    }
		} catch {
		    case ex: Throwable => {
          ex.printStackTrace
          //detailMap.put("exception", ExceptionUtil.completeStackTraceex(ex))
        }
		}
		accessToken
	}  
	
	def download(accessToken : String, siteURL: String, sourceRelativePath : String, targetRelativePath : String, fileName : String) : String = {
	  var httpResponseStr : String = "";
	  var inputStream : InputStream = null;
		var outputStream : FileOutputStream = null;
		try {
		   //Frame SharePoint URL to retrieve all of the files in a folder
		    var wsUrl : String = ""
		    if(fileName.isEmpty())
		      wsUrl = siteURL + "/_api/web/GetFolderByServerRelativeUrl('" + sourceRelativePath + "')/Files";
		    else
  		    wsUrl = siteURL + "/_api/web/GetFolderByServerRelativeUrl('" + sourceRelativePath + "')/Files('"+fileName+"')/$value";
			
		   //Create HttpURLConnection
		   val url : URL = new URL(wsUrl);
		   val connection : URLConnection = url.openConnection();
		   val httpConn : HttpURLConnection = connection.asInstanceOf[HttpURLConnection];
								
		   //Set Header		
		   httpConn.setRequestMethod("GET");				
		   httpConn.setRequestProperty("Authorization", "Bearer " + accessToken);
		   httpConn.setRequestProperty("accept", "application/json;odata=verbose"); //To get response in JSON
		   
		   //FileUtils.copyInputStreamToFile(httpConn.getInputStream, new File(targetRelativePath+fileName))
		     
		   inputStream = httpConn.getInputStream();
		   if(!fileName.isEmpty()){
    			 val fileDirs : File = new File(targetRelativePath);
    			 if (!fileDirs.exists()) {
    			   fileDirs.mkdirs();
    			 }
    			 val saveFilePath : String = targetRelativePath + fileName;
    			 outputStream = new FileOutputStream(saveFilePath);
    			 var bytesRead : Int = -1;
    			 var buffer = Array.ofDim[Byte](1064)
    			 while ({bytesRead = inputStream.read(buffer); bytesRead != -1}) {
    			   outputStream.write(buffer, 0, bytesRead);
    			 }
		   }

		} catch {
		    case ex: Throwable => {
          ex.printStackTrace
          //detailMap.put("exception", ExceptionUtil.completeStackTraceex(ex))
        }
		}finally{
		  if(outputStream != null)
		    outputStream.close();
		  if(inputStream != null)
			  inputStream.close();
		}
		httpResponseStr
	}
	
	def upload(accessToken : String, siteURL: String, sourceRelativePath : String, targetRelativePath : String, fileName : String) : Int = {
	  var response : HttpResponse = null
		try {
		    val file : File = new File(sourceRelativePath+fileName)
		   //Frame SharePoint URL to retrieve all of the files in a folder
		    val wsUrl : String = siteURL + "/_api/web/GetFolderByServerRelativeUrl('"+ targetRelativePath+"')/Files/add(url='" + file.getName + "',overwrite=true)"
			  //println(wsUrl)

		    //Create HttpURLConnection
		   val httpPost : HttpPost = new HttpPost(wsUrl);
								
		   //Set Header		
		   httpPost.addHeader("Accept", "application/json;odata=verbose");
	     httpPost.addHeader("Authorization", "Bearer " + accessToken);
    	 
    	 httpPost.setEntity(new FileEntity(file));
    	  
       val client : HttpClient = new DefaultHttpClient();
	     response = client.execute(httpPost);
		} catch {
		    case ex: Throwable => {
          ex.printStackTrace
        }
		}
		response.getStatusLine().getStatusCode()
	}

	@Override
  def executeIf(): Boolean = {
    sharePoint.getCondition
  }
}
