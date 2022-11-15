grammar Raven;

import JSON;

process:
	'process' name=STRING
	'{'
	   tryBlock=tryClause
	   catchBlock=catchClause
	   finallyBlock= finallyClause
	'}';

tryClause :
	'try'
	'{'
		(actions+=action)*
	'}'
;

finallyClause:
	'finally'
	'{'
		(actions+=action)*
	'}'
;

catchClause:
	'catch'
	'{'
		(actions+=action)*
	'}'
;

action:
	(abort
	|assign
    |callProcess
    |forkProcess
    |spawnProcess
    |dogLeg
	|copyData
	|dropFile
	|loadCsv
	|restApi
	|transform
	|multitude
	|exportCsv
	|createDirectory
    |createFile
    |deleteFileDirectory
    |transferFileDirectory
    |createTAR
    |extractTAR
    |importCsvToDB
    |producerConsumerModel
    |producer
    |consumer
    |pushJson
    |mapJsonContext
    |sharePoint
    |downloadAsset
    |paperItemization
    |autoRotation
    |blankPageRemover
    |qrAttribution
    |fileMerger
    |checksum
    |fileSize
    |ravenVmException
    |uploadAsset
    |docnetAttribution
    |createZip
    |extractZip
    |sorGroupDetails
    |ftpsConnector
    |sftpConnector
    |zeroShotClassifier
    |loadExtractedData
    |absentKeyFilter
    |triageAttribution
    |loadExtractedData
    |absentKeyFilter
    |sorFilter
    |elasticStore
    |pixelTextContentExtraction
    |pixelJSONDataExtraction);


multitude:
    'multitude' 'as' name=STRING ('on' on= STRING)* 'using'
    '{'
		(actions+=action)*
    '}' ('on-condition' condition=expression)* ('fielding' writeThreadCount=NON_ZERO_DIGIT)*;

// this is for creating POJO WRT definition
//attribute:(startProcess);

copyData:
	('copydata' 'as' name=STRING 'from' source=STRING 'to' to=STRING  'using'
	'{'
		value=STRING
	'}' ('on-condition' condition=expression)* ('fielding' writeThreadCount=NON_ZERO_DIGIT)* ('with-fetch-batch-size' fetchBatchSize=NON_ZERO_DIGIT)* ('with-write-batch-size' writeBatchSize=NON_ZERO_DIGIT)*)
	 ;

transform:
	'transform' 'as' name= STRING 'on' on= STRING 'using'
	 '{'
		value+=STRING
	 '}' ('on-condition' condition=expression)* ('do-format' format=expression)*;

loadCsv:
	'loadcsv' 'as' name=STRING 'pid' pid=STRING 'from' source=STRING 'to' to=STRING 'with' delim=STRING 'by-batch'
	limit=STRING 'using'
	'{'
	value=STRING
	'}' ('on-condition' condition=expression)*;

abort:
	'abort' 'as' name=STRING
	'{'
		value=STRING
	'}' ('on-condition' condition=expression)*
;

callProcess:
	'callprocess' 'as' name=STRING 'with-target' target=STRING 'from-file' source=STRING 'using' datasource=STRING
	'for-every'
	'{'
	value=STRING
	'}' ('on-condition' condition=expression)* ('on-parallel-fielding' forkBatchSize=STRING)*;


forkProcess:
	'forkprocess' 'as' name=STRING 'with-target' target=STRING 'from-file' source=STRING 'using' datasource=STRING 'for-every'
	'{'
	value=STRING
	'}' ('watermark' forkBatchSize=STRING)* ('on-condition' condition=expression)*;


spawnProcess:
	'spawn' 'as' name=STRING 'with-target' target=STRING 'from-file' source=STRING  ('on-condition' condition=expression)*;


dogLeg:
	'dogleg' 'as' name=STRING 'use-parent-context' inheritContext=STRING 'using'
	'{'
		processList+=startProcess
	'}'   ('on-condition' condition=expression)*;

startProcess:
	'start-process' name=STRING 'with-file' target=STRING
;

assign:
	'assign' 'as' name=STRING 'source' source=STRING 'using'
	'{'
		value=STRING
	'}' ('on-condition' condition=expression)*
;


dropFile:
	'dropfile' 'as' name=STRING 'in-path' target=STRING ('on-condition' condition=expression)*
;

restApi:
	'restapi' 'as' name=STRING 'source' source=STRING 'using' 'url' url=STRING 'method' method=STRING
	 ('with headers'  headers=json)* ('with params'  params=json )*
	 ('with body type' '{' bodyType=STRING '}')
	'{'
	(value+=restPart)*
	'}' ('on-condition' condition=expression)*;

restPart:
	'{ part' 'as' partName=STRING 'with' partData=STRING ('type as' type=STRING)* '}';


exportCsv:
    'exportCsv' 'as' name=STRING 'source' source=STRING 'executionSource' executionSource=STRING
    ('using' stmt= STRING)* 'targetLocation' targetLocation=STRING
    'using' '{''}'
     ('on-condition' condition=expression)* ('fielding' writeThreadCount=STRING)* ;

importCsvToDB:
	'importCsvToDB' 'as' name= STRING 'target' target=resource 'on' tableName=STRING 'using'
	 '{'
		value+=STRING
	'}' ('on-condition' condition=expression)* ('fielding' writeThreadCount=STRING)* ('batch' batchSize=STRING)*;

extractTAR:
	'extractTAR' 'as' name= STRING 'from' source=STRING 'destination' destination=STRING 'using'
	 '{''}' ('on-condition' condition=expression)*;

createTAR:
	'createTAR' 'as' name= STRING 'from' source=STRING 'destination' destination=STRING 'extension' extension=STRING 'using'
	 '{''}' ('on-condition' condition=expression)*;

createDirectory:
	'createDirectory' 'as' name= STRING 'using'
	 '{'
		directoryPath+=STRING
	 '}' ('on-condition' condition=expression)*;

createFile:
	'createFile' 'as' name= STRING 'location' location=STRING 'fileName' fileName=STRING 'extension' extension=STRING 'using'
	 '{'
		value=STRING
	'}' ('on-condition' condition=expression)*;

deleteFileDirectory:
	'deleteFileDirectory' 'as' name= STRING 'using'
	 '{'
		path+=STRING
	'}' ('on-condition' condition=expression)*;

transferFileDirectory:
	'transferFileDirectory' 'as' name= STRING 'from' source=STRING 'to' to=STRING 'operation' operation=STRING 'using'

		value=STRING
	'}' ('on-condition' condition=expression)*;

producerConsumerModel:
    'pcm' 'as'  name=STRING 'on-resource' source=resource
    'produce''{'
        produce+=producer
    '}' ('fielding' produceThreadCount=STRING)*
    'consume''{'
        consume+=consumer
    '}'('fielding' consumeThreadCount=STRING)*  ('on-condition' condition=expression)*;

producer:
    'producer''as' name=STRING ('push-result-at' push=STRING)*  ('on-resource' source=resource)*
     'for-every''{'
     	stmt=STRING
     '}'
     'execute''{'
       (actions+=action)*
     '}' ('on-condition' condition=expression)* ('fielding' threadCount=STRING)*;

consumer:
    'consumer''as' name=STRING  ( 'pop-event-from' event=STRING 'on-resource' source=resource )*  ('pop-result-from' pop=STRING 'limit' limit=STRING)* 'execute' '{'
       (actions+=action)*
       '}' ('on-condition' condition=expression)* ('fielding' threadCount=STRING)* ('on-standalone' standalone=expression)* ;


pushJson :
     'push-json-into-context' 'as' name=STRING 'with-key' key=STRING 'using-value'  '{'
       value=json
    '}' ('on-condition' condition=expression)* ;

mapJsonContext :
      'map-json-into-context' 'as' name=STRING  'using'  '{'
                        autoRotation                              value=STRING
                                                   '}' ('on-condition' condition=expression)* ;
                                                   
sharePoint:
	'sharepoint' 'as' name=STRING 'client-id' shpClientId=STRING 'tenant-id' shpTenantId=STRING 'client-secret' shpClientSecret=STRING 
	'org-name' orgName=STRING 'action-type' actionType=STRING 'site-url' siteUrl=STRING 'source-relative-path' sourceRelativePath=STRING 
	'file-name' fileName=STRING 'target-relative-path' targetRelativePath=STRING 'using'
	'{'
		value=STRING
	'}' ('on-condition' condition=expression)* ;

expression :'if' (lhs=STRING operator=Operator rhs=STRING);

log:
   'log' 'as' 'level' level=STRING 'with' 'message' '{' message=STRING '}';

ravenVmException:
    'raise exception' 'as' name=STRING 'using' '{' message=STRING '}'('on-condition' condition=expression)* ;

checksum:
    'checksum' 'as' name=STRING 'using' '{' filePath=STRING '}' ('on-condition' condition=expression)* ;

fileSize:
    'fileSize' 'as' name=STRING 'using' '{' filePath=STRING '}' ('on-condition' condition=expression)* ;

downloadAsset:
    'download-asset' 'as' name=STRING 'from-url' url=STRING 'at' location=STRING  'using'  '{' '}' ('on-condition' condition=expression)* ;

paperItemization:
    'paper-itemization' 'as' name=STRING 'from-target-file' filePath=STRING 'using' outputDir=STRING  'using'  '{' '}' ('on-condition' condition=expression)* ;

autoRotation:
    'autoRotation' 'as' name=STRING 'from-target-file' filePath=STRING 'using' outputDir=STRING  'using'  '{' '}' ('on-condition' condition=expression)* ;

blankPageRemover:
    'blankPageRemover' 'as' name=STRING 'from-target-file' filePath=STRING 'using' outputDir=STRING  'using'  '{' '}' ('on-condition' condition=expression)* ;

docnetAttribution:
      'docnetAttribution' 'as' name=STRING 'from-target-file' inputFilePath=STRING 'question-list' questionList=STRING 'absent-key-filter-list' absentKeyFilterList=STRING 'outputDir' outputDir=STRING 'using'  '{' '}' ('on-condition' condition=expression)* ;

qrAttribution:
    'qrAttribution' 'as' name=STRING 'using'  '{' filePath=STRING '}' ('on-condition' condition=expression)* ;

uploadAsset:
    'uploadAsset' 'as' name=STRING 'from-target-file' filePath=STRING 'template-id' templateId=STRING  'auth-token' token=STRING 'using'  '{' '}' ('on-condition' condition=expression)* ;

fileMerger:
    'fileMerger' 'as' name=STRING  'in' outputDir=STRING 'using'  '{' requestBody=STRING '}' ('on-condition' condition=expression)* ;

ftpsConnector:
       'ftps' 'as' name=STRING 'with-remote-host' host=STRING 'port' port=STRING 'user-name' userName=STRING 'password' password=STRING 'session-timeout' sessionTimeOut=STRING 'source-file-to-download' sourceFile=STRING 'in-destination-to-save' destDir=STRING
       'using' '{'     '}' ('on-condition' condition=expression)* ;

sftpConnector:
       'sftp' 'as' name=STRING 'with-remote-host' host=STRING 'port' port=STRING 'user-name' userName=STRING 'password' password=STRING 'session-timeout' sessionTimeOut=STRING 'channel-timeout' channelTimeOut=STRING 'source-file-to-download' sourceFile=STRING 'in-destination-to-save' destDir=STRING
       'ftp' 'as' name=STRING 'with-remote-host' host=STRING 'port' port=STRING 'user-name' userName=STRING 'password' password=STRING 'session-timeout' sessionTimeOut=STRING 'source-file-to-download' sourceFile=STRING 'in-destination-to-save' destDir=STRING
       'using' '{'     '}' ('on-condition' condition=expression)* ;


createZip:
       'create-zip' name = STRING 'file-name' fileName = STRING 'from' source = STRING 'destination' destination=STRING 'using'
        '{' '}' ('on-condition' condition=expression)*;

extractZip:
        'extract-zip' name = STRING 'from' source = STRING 'destination' destination=STRING 'using'
        '{' '}' ('on-condition' condition=expression)*;

sorGroupDetails:
    'sorGroupDetails' 'as' name=STRING 'on' on=STRING 'keyfields' keyfields=STRING  'searchfields' searchfields=STRING
    'groupbyfields' groupbyfields=STRING  'targettable' targettable=STRING 'using'
	'{'
	    value=STRING
	'}' ('on-condition' condition=expression)*;


zeroShotClassifier:
    'zeroShotClassifier' 'as' name=STRING
    'with-candidate-labels' candidateLabels=STRING 'using'
    '{'  content=STRING  '}' ('on-condition' condition=expression)*;


loadExtractedData:
    'loadExtractedData' 'as' name=STRING
    'file-path' filePath=STRING
    'paper-no' paperNo=STRING
    'intics-reference-id' inticsReferenceId=STRING
    'batch-id' batchId=STRING
    'target-dir' targetDir=STRING  'using'
    '{' '}' ('on-condition' condition=expression)*;

absentKeyFilter:
    'absentKeyFilter' 'as' name=STRING
    'file-path' filePath=STRING
    'paper-no' paperNo=STRING
    'intics-reference-id' inticsReferenceId=STRING
    'batch-id' batchId=STRING
    'sor-list' sorList=STRING  'using'
    '{' '}' ('on-condition' condition=expression)*;

sorFilter:
    'sorFilter' 'as' name=STRING
    'file-path' filePath=STRING
    'intics-reference-id' inticsReferenceId=STRING
    'search-value' searchValue=STRING 'using'
    '{' '}' ('on-condition' condition=expression)*;

triageAttribution:
    'triage' 'as' name=STRING
    'in-output-dir' outputDir=STRING
    'with-labelled-classifier-model-path' labelledClassifierModelFilePath=STRING
    'with-handwritten-extractor-model-path' handwrittenClassifierModelFilePath=STRING
    'with-checkbox-extractor-model-path' checkboxClassifierModelFilePath=STRING
    'using-synonyms' synonyms=STRING
    'using-labelled-classifier-labels' labelledClassifierLabels=STRING
    'using-vilt-coco-labels' viltCocoLabels=STRING
    'add-vilt-question-config' viltConfigLabel=STRING
    'add-vilt-coco-overide-config' isViltCocoOverride=STRING
    'add-vilt-coco-threshold-config' viltCocoThreshold=STRING
    'save-response-as'  triageAttributionResponseName=STRING
    '{'  inputFilePath=STRING  '}' ('on-condition' condition=expression)*;


pixelTextContentExtraction:
    'pixel-text-data-extraction' 'as' name=STRING
    'paper-no' paperNo=STRING
    'file-id' inticsReferenceId=STRING
    'using'
    '{' inputFilePath=STRING '}' ('on-condition' condition=expression)*;


pixelJSONDataExtraction:
    'pixel-JSON-data-extraction' 'as' name=STRING
    'paper-no' paperNo=STRING 'output-directory' outputDir=STRING
    'file-id' inticsReferenceId=STRING 'max-doctr-diff' maxDoctrDiff=STRING
    'max-question-diff' maxQuestionDiff=STRING
    'using'
    '{' inputFilePath=STRING '}' ('on-condition' condition=expression)*;

elasticStore:
    'store-data-in-es' 'as' name=STRING 'with-host' host=STRING
    'user' user=STRING 'password' password=STRING
    'index-name' indexName=STRING 'index-type' indexType=STRING
    '{'
         dataNode=STRING
    '}' ('on-condition' condition=expression)*;


resource : STRING;

//rules

fragment DIGIT : [0-9];
fragment NON_Z_DIGIT : [1-9];
fragment TWODIGIT : DIGIT DIGIT;
fragment LETTER : [A-Za-z];
fragment
StringCharacters
	:	StringCharacter+
	;
fragment
StringCharacter
	:	~["\\]
	;
NON_ZERO_DIGIT: NON_Z_DIGIT+;
STRING :	'"' StringCharacters? '"';
CRLF : ('\r'? '\n' | '\r')-> channel(HIDDEN) ;
Operator:
	'<'|'>'|'=='|'contains'
;
WS  :  [ \t\r\n\u000C]+ -> channel(HIDDEN)
    ;
COMMENT
    :   '/*' .*? '*/' -> channel(HIDDEN)
    ;
LINE_COMMENT
    :   '//' ~[\r\n]* -> channel(HIDDEN)
    ;
