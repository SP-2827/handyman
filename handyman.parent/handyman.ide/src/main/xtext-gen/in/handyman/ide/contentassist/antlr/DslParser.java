/*
 * generated by Xtext 2.16.0
 */
package in.handyman.ide.contentassist.antlr;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import in.handyman.ide.contentassist.antlr.internal.InternalDslParser;
import in.handyman.services.DslGrammarAccess;
import java.util.Map;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;

public class DslParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(DslGrammarAccess grammarAccess) {
			ImmutableMap.Builder<AbstractElement, String> builder = ImmutableMap.builder();
			init(builder, grammarAccess);
			this.mappings = builder.build();
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(ImmutableMap.Builder<AbstractElement, String> builder, DslGrammarAccess grammarAccess) {
			builder.put(grammarAccess.getActionAccess().getAlternatives(), "rule__Action__Alternatives");
			builder.put(grammarAccess.getOperatorAccess().getAlternatives(), "rule__Operator__Alternatives");
			builder.put(grammarAccess.getProcessAccess().getGroup(), "rule__Process__Group__0");
			builder.put(grammarAccess.getTryAccess().getGroup(), "rule__Try__Group__0");
			builder.put(grammarAccess.getFinallyAccess().getGroup(), "rule__Finally__Group__0");
			builder.put(grammarAccess.getCatchAccess().getGroup(), "rule__Catch__Group__0");
			builder.put(grammarAccess.getEsUpdateAccess().getGroup(), "rule__EsUpdate__Group__0");
			builder.put(grammarAccess.getEsAccumulateAccess().getGroup(), "rule__EsAccumulate__Group__0");
			builder.put(grammarAccess.getElasticFBCLeadAccess().getGroup(), "rule__ElasticFBCLead__Group__0");
			builder.put(grammarAccess.getElasticGETAccess().getGroup(), "rule__ElasticGET__Group__0");
			builder.put(grammarAccess.getExecJavaAccess().getGroup(), "rule__ExecJava__Group__0");
			builder.put(grammarAccess.getFirebaseDatabasePutAccess().getGroup(), "rule__FirebaseDatabasePut__Group__0");
			builder.put(grammarAccess.getFirebaseReactiveNotificationAccess().getGroup(), "rule__FirebaseReactiveNotification__Group__0");
			builder.put(grammarAccess.getSmsLeadSmsAccess().getGroup(), "rule__SmsLeadSms__Group__0");
			builder.put(grammarAccess.getAbortAccess().getGroup(), "rule__Abort__Group__0");
			builder.put(grammarAccess.getGooglecontactSelectAllAccess().getGroup(), "rule__GooglecontactSelectAll__Group__0");
			builder.put(grammarAccess.getSendMailAccess().getGroup(), "rule__SendMail__Group__0");
			builder.put(grammarAccess.getGooglecontactPUTAccess().getGroup(), "rule__GooglecontactPUT__Group__0");
			builder.put(grammarAccess.getGooglecalPUTAccess().getGroup(), "rule__GooglecalPUT__Group__0");
			builder.put(grammarAccess.getFBCLeadAccess().getGroup(), "rule__FBCLead__Group__0");
			builder.put(grammarAccess.getFBFormDownloadAccess().getGroup(), "rule__FBFormDownload__Group__0");
			builder.put(grammarAccess.getDropfileAccess().getGroup(), "rule__Dropfile__Group__0");
			builder.put(grammarAccess.getDoozleAccess().getGroup(), "rule__Doozle__Group__0");
			builder.put(grammarAccess.getRestAccess().getGroup(), "rule__Rest__Group__0");
			builder.put(grammarAccess.getRestPartAccess().getGroup(), "rule__RestPart__Group__0");
			builder.put(grammarAccess.getTrelloGETAccess().getGroup(), "rule__TrelloGET__Group__0");
			builder.put(grammarAccess.getTrelloPUTAccess().getGroup(), "rule__TrelloPUT__Group__0");
			builder.put(grammarAccess.getFetchAccess().getGroup(), "rule__Fetch__Group__0");
			builder.put(grammarAccess.getCallprocessAccess().getGroup(), "rule__Callprocess__Group__0");
			builder.put(grammarAccess.getUpdatedauditAccess().getGroup(), "rule__Updatedaudit__Group__0");
			builder.put(grammarAccess.getClickSendSmsAccess().getGroup(), "rule__ClickSendSms__Group__0");
			builder.put(grammarAccess.getSlackPUTAccess().getGroup(), "rule__SlackPUT__Group__0");
			builder.put(grammarAccess.getCopydataAccess().getGroup(), "rule__Copydata__Group__0");
			builder.put(grammarAccess.getWriteCsvAccess().getGroup(), "rule__WriteCsv__Group__0");
			builder.put(grammarAccess.getLoadCsvAccess().getGroup(), "rule__LoadCsv__Group__0");
			builder.put(grammarAccess.getTransformAccess().getGroup(), "rule__Transform__Group__0");
			builder.put(grammarAccess.getExpressionAccess().getGroup(), "rule__Expression__Group__0");
			builder.put(grammarAccess.getProcessAccess().getNameAssignment_1(), "rule__Process__NameAssignment_1");
			builder.put(grammarAccess.getProcessAccess().getTryAssignment_3(), "rule__Process__TryAssignment_3");
			builder.put(grammarAccess.getProcessAccess().getCatchAssignment_4(), "rule__Process__CatchAssignment_4");
			builder.put(grammarAccess.getProcessAccess().getFinallyAssignment_5(), "rule__Process__FinallyAssignment_5");
			builder.put(grammarAccess.getTryAccess().getNameAssignment_1(), "rule__Try__NameAssignment_1");
			builder.put(grammarAccess.getTryAccess().getActionAssignment_3(), "rule__Try__ActionAssignment_3");
			builder.put(grammarAccess.getFinallyAccess().getNameAssignment_1(), "rule__Finally__NameAssignment_1");
			builder.put(grammarAccess.getFinallyAccess().getActionAssignment_3(), "rule__Finally__ActionAssignment_3");
			builder.put(grammarAccess.getCatchAccess().getNameAssignment_1(), "rule__Catch__NameAssignment_1");
			builder.put(grammarAccess.getCatchAccess().getActionAssignment_3(), "rule__Catch__ActionAssignment_3");
			builder.put(grammarAccess.getEsUpdateAccess().getNameAssignment_2(), "rule__EsUpdate__NameAssignment_2");
			builder.put(grammarAccess.getEsUpdateAccess().getSourceAssignment_4(), "rule__EsUpdate__SourceAssignment_4");
			builder.put(grammarAccess.getEsUpdateAccess().getTargetAssignment_6(), "rule__EsUpdate__TargetAssignment_6");
			builder.put(grammarAccess.getEsUpdateAccess().getFetchSizeAssignment_8(), "rule__EsUpdate__FetchSizeAssignment_8");
			builder.put(grammarAccess.getEsUpdateAccess().getWriteSizeAssignment_10(), "rule__EsUpdate__WriteSizeAssignment_10");
			builder.put(grammarAccess.getEsUpdateAccess().getValueAssignment_13(), "rule__EsUpdate__ValueAssignment_13");
			builder.put(grammarAccess.getEsUpdateAccess().getConditionAssignment_16(), "rule__EsUpdate__ConditionAssignment_16");
			builder.put(grammarAccess.getEsUpdateAccess().getWriteThreadCountAssignment_18(), "rule__EsUpdate__WriteThreadCountAssignment_18");
			builder.put(grammarAccess.getEsAccumulateAccess().getNameAssignment_2(), "rule__EsAccumulate__NameAssignment_2");
			builder.put(grammarAccess.getEsAccumulateAccess().getSourceAssignment_4(), "rule__EsAccumulate__SourceAssignment_4");
			builder.put(grammarAccess.getEsAccumulateAccess().getTargetAssignment_6(), "rule__EsAccumulate__TargetAssignment_6");
			builder.put(grammarAccess.getEsAccumulateAccess().getFetchSizeAssignment_8(), "rule__EsAccumulate__FetchSizeAssignment_8");
			builder.put(grammarAccess.getEsAccumulateAccess().getWriteSizeAssignment_10(), "rule__EsAccumulate__WriteSizeAssignment_10");
			builder.put(grammarAccess.getEsAccumulateAccess().getValueAssignment_13(), "rule__EsAccumulate__ValueAssignment_13");
			builder.put(grammarAccess.getEsAccumulateAccess().getConditionAssignment_16(), "rule__EsAccumulate__ConditionAssignment_16");
			builder.put(grammarAccess.getEsAccumulateAccess().getWriteThreadCountAssignment_18(), "rule__EsAccumulate__WriteThreadCountAssignment_18");
			builder.put(grammarAccess.getElasticFBCLeadAccess().getNameAssignment_2(), "rule__ElasticFBCLead__NameAssignment_2");
			builder.put(grammarAccess.getElasticFBCLeadAccess().getAccessTokenAssignment_4(), "rule__ElasticFBCLead__AccessTokenAssignment_4");
			builder.put(grammarAccess.getElasticFBCLeadAccess().getAppSecretAssignment_6(), "rule__ElasticFBCLead__AppSecretAssignment_6");
			builder.put(grammarAccess.getElasticFBCLeadAccess().getAccountIdAssignment_8(), "rule__ElasticFBCLead__AccountIdAssignment_8");
			builder.put(grammarAccess.getElasticFBCLeadAccess().getCampaignIdAssignment_10(), "rule__ElasticFBCLead__CampaignIdAssignment_10");
			builder.put(grammarAccess.getElasticFBCLeadAccess().getTargetAssignment_12(), "rule__ElasticFBCLead__TargetAssignment_12");
			builder.put(grammarAccess.getElasticFBCLeadAccess().getValueAssignment_15(), "rule__ElasticFBCLead__ValueAssignment_15");
			builder.put(grammarAccess.getElasticFBCLeadAccess().getConditionAssignment_18(), "rule__ElasticFBCLead__ConditionAssignment_18");
			builder.put(grammarAccess.getElasticGETAccess().getNameAssignment_2(), "rule__ElasticGET__NameAssignment_2");
			builder.put(grammarAccess.getElasticGETAccess().getSourceAssignment_4(), "rule__ElasticGET__SourceAssignment_4");
			builder.put(grammarAccess.getElasticGETAccess().getToAssignment_6(), "rule__ElasticGET__ToAssignment_6");
			builder.put(grammarAccess.getElasticGETAccess().getValueAssignment_9(), "rule__ElasticGET__ValueAssignment_9");
			builder.put(grammarAccess.getElasticGETAccess().getConditionAssignment_12(), "rule__ElasticGET__ConditionAssignment_12");
			builder.put(grammarAccess.getExecJavaAccess().getNameAssignment_2(), "rule__ExecJava__NameAssignment_2");
			builder.put(grammarAccess.getExecJavaAccess().getClassFqnAssignment_4(), "rule__ExecJava__ClassFqnAssignment_4");
			builder.put(grammarAccess.getExecJavaAccess().getDbSrcAssignment_6(), "rule__ExecJava__DbSrcAssignment_6");
			builder.put(grammarAccess.getExecJavaAccess().getValueAssignment_8(), "rule__ExecJava__ValueAssignment_8");
			builder.put(grammarAccess.getExecJavaAccess().getConditionAssignment_11(), "rule__ExecJava__ConditionAssignment_11");
			builder.put(grammarAccess.getFirebaseDatabasePutAccess().getNameAssignment_2(), "rule__FirebaseDatabasePut__NameAssignment_2");
			builder.put(grammarAccess.getFirebaseDatabasePutAccess().getUrlAssignment_4(), "rule__FirebaseDatabasePut__UrlAssignment_4");
			builder.put(grammarAccess.getFirebaseDatabasePutAccess().getFbjsonAssignment_6(), "rule__FirebaseDatabasePut__FbjsonAssignment_6");
			builder.put(grammarAccess.getFirebaseDatabasePutAccess().getGroupPathAssignment_8(), "rule__FirebaseDatabasePut__GroupPathAssignment_8");
			builder.put(grammarAccess.getFirebaseDatabasePutAccess().getDbSrcAssignment_10(), "rule__FirebaseDatabasePut__DbSrcAssignment_10");
			builder.put(grammarAccess.getFirebaseDatabasePutAccess().getClassFqnAssignment_12(), "rule__FirebaseDatabasePut__ClassFqnAssignment_12");
			builder.put(grammarAccess.getFirebaseDatabasePutAccess().getValueAssignment_15(), "rule__FirebaseDatabasePut__ValueAssignment_15");
			builder.put(grammarAccess.getFirebaseDatabasePutAccess().getConditionAssignment_18(), "rule__FirebaseDatabasePut__ConditionAssignment_18");
			builder.put(grammarAccess.getFirebaseReactiveNotificationAccess().getNameAssignment_2(), "rule__FirebaseReactiveNotification__NameAssignment_2");
			builder.put(grammarAccess.getFirebaseReactiveNotificationAccess().getUrlAssignment_4(), "rule__FirebaseReactiveNotification__UrlAssignment_4");
			builder.put(grammarAccess.getFirebaseReactiveNotificationAccess().getFbjsonAssignment_6(), "rule__FirebaseReactiveNotification__FbjsonAssignment_6");
			builder.put(grammarAccess.getFirebaseReactiveNotificationAccess().getGroupPathAssignment_8(), "rule__FirebaseReactiveNotification__GroupPathAssignment_8");
			builder.put(grammarAccess.getFirebaseReactiveNotificationAccess().getClassFqnAssignment_10(), "rule__FirebaseReactiveNotification__ClassFqnAssignment_10");
			builder.put(grammarAccess.getFirebaseReactiveNotificationAccess().getDbSrcAssignment_12(), "rule__FirebaseReactiveNotification__DbSrcAssignment_12");
			builder.put(grammarAccess.getFirebaseReactiveNotificationAccess().getConditionAssignment_14(), "rule__FirebaseReactiveNotification__ConditionAssignment_14");
			builder.put(grammarAccess.getSmsLeadSmsAccess().getNameAssignment_2(), "rule__SmsLeadSms__NameAssignment_2");
			builder.put(grammarAccess.getSmsLeadSmsAccess().getUrlAssignment_4(), "rule__SmsLeadSms__UrlAssignment_4");
			builder.put(grammarAccess.getSmsLeadSmsAccess().getSenderAssignment_6(), "rule__SmsLeadSms__SenderAssignment_6");
			builder.put(grammarAccess.getSmsLeadSmsAccess().getAccountAssignment_8(), "rule__SmsLeadSms__AccountAssignment_8");
			builder.put(grammarAccess.getSmsLeadSmsAccess().getPrivateKeyAssignment_10(), "rule__SmsLeadSms__PrivateKeyAssignment_10");
			builder.put(grammarAccess.getSmsLeadSmsAccess().getDbSrcAssignment_12(), "rule__SmsLeadSms__DbSrcAssignment_12");
			builder.put(grammarAccess.getSmsLeadSmsAccess().getValueAssignment_15(), "rule__SmsLeadSms__ValueAssignment_15");
			builder.put(grammarAccess.getSmsLeadSmsAccess().getConditionAssignment_18(), "rule__SmsLeadSms__ConditionAssignment_18");
			builder.put(grammarAccess.getSmsLeadSmsAccess().getDryrunNumberAssignment_20(), "rule__SmsLeadSms__DryrunNumberAssignment_20");
			builder.put(grammarAccess.getAbortAccess().getNameAssignment_2(), "rule__Abort__NameAssignment_2");
			builder.put(grammarAccess.getAbortAccess().getValueAssignment_4(), "rule__Abort__ValueAssignment_4");
			builder.put(grammarAccess.getAbortAccess().getConditionAssignment_7(), "rule__Abort__ConditionAssignment_7");
			builder.put(grammarAccess.getGooglecontactSelectAllAccess().getNameAssignment_2(), "rule__GooglecontactSelectAll__NameAssignment_2");
			builder.put(grammarAccess.getGooglecontactSelectAllAccess().getAccountAssignment_4(), "rule__GooglecontactSelectAll__AccountAssignment_4");
			builder.put(grammarAccess.getGooglecontactSelectAllAccess().getPrivateKeyAssignment_6(), "rule__GooglecontactSelectAll__PrivateKeyAssignment_6");
			builder.put(grammarAccess.getGooglecontactSelectAllAccess().getPtwelveFileAssignment_8(), "rule__GooglecontactSelectAll__PtwelveFileAssignment_8");
			builder.put(grammarAccess.getGooglecontactSelectAllAccess().getProjectAssignment_10(), "rule__GooglecontactSelectAll__ProjectAssignment_10");
			builder.put(grammarAccess.getGooglecontactSelectAllAccess().getImpersonatedUserAssignment_12(), "rule__GooglecontactSelectAll__ImpersonatedUserAssignment_12");
			builder.put(grammarAccess.getGooglecontactSelectAllAccess().getDbSrcAssignment_14(), "rule__GooglecontactSelectAll__DbSrcAssignment_14");
			builder.put(grammarAccess.getGooglecontactSelectAllAccess().getValueAssignment_17(), "rule__GooglecontactSelectAll__ValueAssignment_17");
			builder.put(grammarAccess.getGooglecontactSelectAllAccess().getConditionAssignment_20(), "rule__GooglecontactSelectAll__ConditionAssignment_20");
			builder.put(grammarAccess.getSendMailAccess().getNameAssignment_2(), "rule__SendMail__NameAssignment_2");
			builder.put(grammarAccess.getSendMailAccess().getPrivateKeyAssignment_4(), "rule__SendMail__PrivateKeyAssignment_4");
			builder.put(grammarAccess.getSendMailAccess().getImpersonatedUserAssignment_6(), "rule__SendMail__ImpersonatedUserAssignment_6");
			builder.put(grammarAccess.getSendMailAccess().getDbSrcAssignment_8(), "rule__SendMail__DbSrcAssignment_8");
			builder.put(grammarAccess.getSendMailAccess().getValueAssignment_11(), "rule__SendMail__ValueAssignment_11");
			builder.put(grammarAccess.getSendMailAccess().getConditionAssignment_14(), "rule__SendMail__ConditionAssignment_14");
			builder.put(grammarAccess.getSendMailAccess().getDryrunMailAssignment_16(), "rule__SendMail__DryrunMailAssignment_16");
			builder.put(grammarAccess.getGooglecontactPUTAccess().getNameAssignment_2(), "rule__GooglecontactPUT__NameAssignment_2");
			builder.put(grammarAccess.getGooglecontactPUTAccess().getAccountAssignment_4(), "rule__GooglecontactPUT__AccountAssignment_4");
			builder.put(grammarAccess.getGooglecontactPUTAccess().getPrivateKeyAssignment_6(), "rule__GooglecontactPUT__PrivateKeyAssignment_6");
			builder.put(grammarAccess.getGooglecontactPUTAccess().getPtwelveFileAssignment_8(), "rule__GooglecontactPUT__PtwelveFileAssignment_8");
			builder.put(grammarAccess.getGooglecontactPUTAccess().getProjectAssignment_10(), "rule__GooglecontactPUT__ProjectAssignment_10");
			builder.put(grammarAccess.getGooglecontactPUTAccess().getImpersonatedUserAssignment_12(), "rule__GooglecontactPUT__ImpersonatedUserAssignment_12");
			builder.put(grammarAccess.getGooglecontactPUTAccess().getDbSrcAssignment_14(), "rule__GooglecontactPUT__DbSrcAssignment_14");
			builder.put(grammarAccess.getGooglecontactPUTAccess().getValueAssignment_17(), "rule__GooglecontactPUT__ValueAssignment_17");
			builder.put(grammarAccess.getGooglecontactPUTAccess().getConditionAssignment_20(), "rule__GooglecontactPUT__ConditionAssignment_20");
			builder.put(grammarAccess.getGooglecalPUTAccess().getNameAssignment_2(), "rule__GooglecalPUT__NameAssignment_2");
			builder.put(grammarAccess.getGooglecalPUTAccess().getAccountAssignment_4(), "rule__GooglecalPUT__AccountAssignment_4");
			builder.put(grammarAccess.getGooglecalPUTAccess().getPrivateKeyAssignment_6(), "rule__GooglecalPUT__PrivateKeyAssignment_6");
			builder.put(grammarAccess.getGooglecalPUTAccess().getPtwelveFileAssignment_8(), "rule__GooglecalPUT__PtwelveFileAssignment_8");
			builder.put(grammarAccess.getGooglecalPUTAccess().getProjectAssignment_10(), "rule__GooglecalPUT__ProjectAssignment_10");
			builder.put(grammarAccess.getGooglecalPUTAccess().getImpersonatedUserAssignment_12(), "rule__GooglecalPUT__ImpersonatedUserAssignment_12");
			builder.put(grammarAccess.getGooglecalPUTAccess().getDbSrcAssignment_14(), "rule__GooglecalPUT__DbSrcAssignment_14");
			builder.put(grammarAccess.getGooglecalPUTAccess().getValueAssignment_17(), "rule__GooglecalPUT__ValueAssignment_17");
			builder.put(grammarAccess.getGooglecalPUTAccess().getConditionAssignment_20(), "rule__GooglecalPUT__ConditionAssignment_20");
			builder.put(grammarAccess.getFBCLeadAccess().getNameAssignment_2(), "rule__FBCLead__NameAssignment_2");
			builder.put(grammarAccess.getFBCLeadAccess().getAccessTokenAssignment_4(), "rule__FBCLead__AccessTokenAssignment_4");
			builder.put(grammarAccess.getFBCLeadAccess().getAppSecretAssignment_6(), "rule__FBCLead__AppSecretAssignment_6");
			builder.put(grammarAccess.getFBCLeadAccess().getAccountIdAssignment_8(), "rule__FBCLead__AccountIdAssignment_8");
			builder.put(grammarAccess.getFBCLeadAccess().getCampaignIdAssignment_10(), "rule__FBCLead__CampaignIdAssignment_10");
			builder.put(grammarAccess.getFBCLeadAccess().getTargetAssignment_12(), "rule__FBCLead__TargetAssignment_12");
			builder.put(grammarAccess.getFBCLeadAccess().getValueAssignment_15(), "rule__FBCLead__ValueAssignment_15");
			builder.put(grammarAccess.getFBCLeadAccess().getConditionAssignment_18(), "rule__FBCLead__ConditionAssignment_18");
			builder.put(grammarAccess.getFBFormDownloadAccess().getNameAssignment_2(), "rule__FBFormDownload__NameAssignment_2");
			builder.put(grammarAccess.getFBFormDownloadAccess().getAccessTokenAssignment_4(), "rule__FBFormDownload__AccessTokenAssignment_4");
			builder.put(grammarAccess.getFBFormDownloadAccess().getAppSecretAssignment_6(), "rule__FBFormDownload__AppSecretAssignment_6");
			builder.put(grammarAccess.getFBFormDownloadAccess().getAccountIdAssignment_8(), "rule__FBFormDownload__AccountIdAssignment_8");
			builder.put(grammarAccess.getFBFormDownloadAccess().getFormIdAssignment_10(), "rule__FBFormDownload__FormIdAssignment_10");
			builder.put(grammarAccess.getFBFormDownloadAccess().getTargetAssignment_12(), "rule__FBFormDownload__TargetAssignment_12");
			builder.put(grammarAccess.getFBFormDownloadAccess().getValueAssignment_15(), "rule__FBFormDownload__ValueAssignment_15");
			builder.put(grammarAccess.getFBFormDownloadAccess().getConditionAssignment_18(), "rule__FBFormDownload__ConditionAssignment_18");
			builder.put(grammarAccess.getDropfileAccess().getNameAssignment_2(), "rule__Dropfile__NameAssignment_2");
			builder.put(grammarAccess.getDropfileAccess().getTargetAssignment_4(), "rule__Dropfile__TargetAssignment_4");
			builder.put(grammarAccess.getDropfileAccess().getConditionAssignment_6(), "rule__Dropfile__ConditionAssignment_6");
			builder.put(grammarAccess.getDoozleAccess().getNameAssignment_2(), "rule__Doozle__NameAssignment_2");
			builder.put(grammarAccess.getDoozleAccess().getTargetAssignment_4(), "rule__Doozle__TargetAssignment_4");
			builder.put(grammarAccess.getDoozleAccess().getOnAssignment_6(), "rule__Doozle__OnAssignment_6");
			builder.put(grammarAccess.getDoozleAccess().getValueAssignment_9(), "rule__Doozle__ValueAssignment_9");
			builder.put(grammarAccess.getDoozleAccess().getConditionAssignment_12(), "rule__Doozle__ConditionAssignment_12");
			builder.put(grammarAccess.getRestAccess().getNameAssignment_2(), "rule__Rest__NameAssignment_2");
			builder.put(grammarAccess.getRestAccess().getAuthtokenAssignment_4(), "rule__Rest__AuthtokenAssignment_4");
			builder.put(grammarAccess.getRestAccess().getUrlAssignment_6(), "rule__Rest__UrlAssignment_6");
			builder.put(grammarAccess.getRestAccess().getMethodAssignment_8(), "rule__Rest__MethodAssignment_8");
			builder.put(grammarAccess.getRestAccess().getResourcedatafromAssignment_11(), "rule__Rest__ResourcedatafromAssignment_11");
			builder.put(grammarAccess.getRestAccess().getUrldataAssignment_14(), "rule__Rest__UrldataAssignment_14");
			builder.put(grammarAccess.getRestAccess().getHeaderdatafromAssignment_17(), "rule__Rest__HeaderdatafromAssignment_17");
			builder.put(grammarAccess.getRestAccess().getHeaderdataAssignment_20(), "rule__Rest__HeaderdataAssignment_20");
			builder.put(grammarAccess.getRestAccess().getPostdatafromAssignment_23(), "rule__Rest__PostdatafromAssignment_23");
			builder.put(grammarAccess.getRestAccess().getParentNameAssignment_28(), "rule__Rest__ParentNameAssignment_28");
			builder.put(grammarAccess.getRestAccess().getParentdataAssignment_29(), "rule__Rest__ParentdataAssignment_29");
			builder.put(grammarAccess.getRestAccess().getPartsAssignment_30(), "rule__Rest__PartsAssignment_30");
			builder.put(grammarAccess.getRestAccess().getAckdatatoAssignment_33(), "rule__Rest__AckdatatoAssignment_33");
			builder.put(grammarAccess.getRestAccess().getAckdataAssignment_36(), "rule__Rest__AckdataAssignment_36");
			builder.put(grammarAccess.getRestAccess().getConditionAssignment_40(), "rule__Rest__ConditionAssignment_40");
			builder.put(grammarAccess.getRestPartAccess().getPartNameAssignment_2(), "rule__RestPart__PartNameAssignment_2");
			builder.put(grammarAccess.getRestPartAccess().getPartDataAssignment_4(), "rule__RestPart__PartDataAssignment_4");
			builder.put(grammarAccess.getTrelloGETAccess().getNameAssignment_2(), "rule__TrelloGET__NameAssignment_2");
			builder.put(grammarAccess.getTrelloGETAccess().getAuthtokenAssignment_4(), "rule__TrelloGET__AuthtokenAssignment_4");
			builder.put(grammarAccess.getTrelloGETAccess().getKeyAssignment_6(), "rule__TrelloGET__KeyAssignment_6");
			builder.put(grammarAccess.getTrelloGETAccess().getUseraccountAssignment_8(), "rule__TrelloGET__UseraccountAssignment_8");
			builder.put(grammarAccess.getTrelloGETAccess().getBoardAssignment_10(), "rule__TrelloGET__BoardAssignment_10");
			builder.put(grammarAccess.getTrelloGETAccess().getTargetAssignment_12(), "rule__TrelloGET__TargetAssignment_12");
			builder.put(grammarAccess.getTrelloGETAccess().getValueAssignment_15(), "rule__TrelloGET__ValueAssignment_15");
			builder.put(grammarAccess.getTrelloGETAccess().getConditionAssignment_18(), "rule__TrelloGET__ConditionAssignment_18");
			builder.put(grammarAccess.getTrelloPUTAccess().getNameAssignment_2(), "rule__TrelloPUT__NameAssignment_2");
			builder.put(grammarAccess.getTrelloPUTAccess().getAuthtokenAssignment_4(), "rule__TrelloPUT__AuthtokenAssignment_4");
			builder.put(grammarAccess.getTrelloPUTAccess().getKeyAssignment_6(), "rule__TrelloPUT__KeyAssignment_6");
			builder.put(grammarAccess.getTrelloPUTAccess().getUseraccountAssignment_8(), "rule__TrelloPUT__UseraccountAssignment_8");
			builder.put(grammarAccess.getTrelloPUTAccess().getListAssignment_10(), "rule__TrelloPUT__ListAssignment_10");
			builder.put(grammarAccess.getTrelloPUTAccess().getSourceAssignment_12(), "rule__TrelloPUT__SourceAssignment_12");
			builder.put(grammarAccess.getTrelloPUTAccess().getValueAssignment_15(), "rule__TrelloPUT__ValueAssignment_15");
			builder.put(grammarAccess.getTrelloPUTAccess().getConditionAssignment_18(), "rule__TrelloPUT__ConditionAssignment_18");
			builder.put(grammarAccess.getFetchAccess().getNameAssignment_2(), "rule__Fetch__NameAssignment_2");
			builder.put(grammarAccess.getFetchAccess().getSourceAssignment_4(), "rule__Fetch__SourceAssignment_4");
			builder.put(grammarAccess.getFetchAccess().getValueAssignment_7(), "rule__Fetch__ValueAssignment_7");
			builder.put(grammarAccess.getFetchAccess().getConditionAssignment_10(), "rule__Fetch__ConditionAssignment_10");
			builder.put(grammarAccess.getCallprocessAccess().getNameAssignment_2(), "rule__Callprocess__NameAssignment_2");
			builder.put(grammarAccess.getCallprocessAccess().getTargetAssignment_4(), "rule__Callprocess__TargetAssignment_4");
			builder.put(grammarAccess.getCallprocessAccess().getSourceAssignment_6(), "rule__Callprocess__SourceAssignment_6");
			builder.put(grammarAccess.getCallprocessAccess().getDatasourceAssignment_8(), "rule__Callprocess__DatasourceAssignment_8");
			builder.put(grammarAccess.getCallprocessAccess().getValueAssignment_11(), "rule__Callprocess__ValueAssignment_11");
			builder.put(grammarAccess.getCallprocessAccess().getConditionAssignment_14(), "rule__Callprocess__ConditionAssignment_14");
			builder.put(grammarAccess.getUpdatedauditAccess().getNameAssignment_2(), "rule__Updatedaudit__NameAssignment_2");
			builder.put(grammarAccess.getUpdatedauditAccess().getLogsinkAssignment_4(), "rule__Updatedaudit__LogsinkAssignment_4");
			builder.put(grammarAccess.getUpdatedauditAccess().getDatasourceAssignment_6(), "rule__Updatedaudit__DatasourceAssignment_6");
			builder.put(grammarAccess.getUpdatedauditAccess().getValueAssignment_9(), "rule__Updatedaudit__ValueAssignment_9");
			builder.put(grammarAccess.getUpdatedauditAccess().getConditionAssignment_12(), "rule__Updatedaudit__ConditionAssignment_12");
			builder.put(grammarAccess.getClickSendSmsAccess().getNameAssignment_2(), "rule__ClickSendSms__NameAssignment_2");
			builder.put(grammarAccess.getClickSendSmsAccess().getUseridAssignment_4(), "rule__ClickSendSms__UseridAssignment_4");
			builder.put(grammarAccess.getClickSendSmsAccess().getSecurityKeyAssignment_6(), "rule__ClickSendSms__SecurityKeyAssignment_6");
			builder.put(grammarAccess.getClickSendSmsAccess().getTargetAssignment_8(), "rule__ClickSendSms__TargetAssignment_8");
			builder.put(grammarAccess.getClickSendSmsAccess().getValueAssignment_11(), "rule__ClickSendSms__ValueAssignment_11");
			builder.put(grammarAccess.getClickSendSmsAccess().getConditionAssignment_14(), "rule__ClickSendSms__ConditionAssignment_14");
			builder.put(grammarAccess.getSlackPUTAccess().getNameAssignment_2(), "rule__SlackPUT__NameAssignment_2");
			builder.put(grammarAccess.getSlackPUTAccess().getTeamAssignment_4(), "rule__SlackPUT__TeamAssignment_4");
			builder.put(grammarAccess.getSlackPUTAccess().getChannelAssignment_6(), "rule__SlackPUT__ChannelAssignment_6");
			builder.put(grammarAccess.getSlackPUTAccess().getValueAssignment_9(), "rule__SlackPUT__ValueAssignment_9");
			builder.put(grammarAccess.getSlackPUTAccess().getConditionAssignment_12(), "rule__SlackPUT__ConditionAssignment_12");
			builder.put(grammarAccess.getCopydataAccess().getNameAssignment_2(), "rule__Copydata__NameAssignment_2");
			builder.put(grammarAccess.getCopydataAccess().getSourceAssignment_4(), "rule__Copydata__SourceAssignment_4");
			builder.put(grammarAccess.getCopydataAccess().getToAssignment_6(), "rule__Copydata__ToAssignment_6");
			builder.put(grammarAccess.getCopydataAccess().getValueAssignment_9(), "rule__Copydata__ValueAssignment_9");
			builder.put(grammarAccess.getCopydataAccess().getConditionAssignment_12(), "rule__Copydata__ConditionAssignment_12");
			builder.put(grammarAccess.getWriteCsvAccess().getNameAssignment_2(), "rule__WriteCsv__NameAssignment_2");
			builder.put(grammarAccess.getWriteCsvAccess().getSourceAssignment_4(), "rule__WriteCsv__SourceAssignment_4");
			builder.put(grammarAccess.getWriteCsvAccess().getToAssignment_6(), "rule__WriteCsv__ToAssignment_6");
			builder.put(grammarAccess.getWriteCsvAccess().getDelimAssignment_8(), "rule__WriteCsv__DelimAssignment_8");
			builder.put(grammarAccess.getWriteCsvAccess().getValueAssignment_11(), "rule__WriteCsv__ValueAssignment_11");
			builder.put(grammarAccess.getWriteCsvAccess().getConditionAssignment_14(), "rule__WriteCsv__ConditionAssignment_14");
			builder.put(grammarAccess.getLoadCsvAccess().getNameAssignment_2(), "rule__LoadCsv__NameAssignment_2");
			builder.put(grammarAccess.getLoadCsvAccess().getSourceAssignment_4(), "rule__LoadCsv__SourceAssignment_4");
			builder.put(grammarAccess.getLoadCsvAccess().getToAssignment_6(), "rule__LoadCsv__ToAssignment_6");
			builder.put(grammarAccess.getLoadCsvAccess().getDelimAssignment_8(), "rule__LoadCsv__DelimAssignment_8");
			builder.put(grammarAccess.getLoadCsvAccess().getValueAssignment_11(), "rule__LoadCsv__ValueAssignment_11");
			builder.put(grammarAccess.getLoadCsvAccess().getConditionAssignment_14(), "rule__LoadCsv__ConditionAssignment_14");
			builder.put(grammarAccess.getTransformAccess().getNameAssignment_2(), "rule__Transform__NameAssignment_2");
			builder.put(grammarAccess.getTransformAccess().getOnAssignment_4(), "rule__Transform__OnAssignment_4");
			builder.put(grammarAccess.getTransformAccess().getValueAssignment_7(), "rule__Transform__ValueAssignment_7");
			builder.put(grammarAccess.getTransformAccess().getConditionAssignment_10(), "rule__Transform__ConditionAssignment_10");
			builder.put(grammarAccess.getExpressionAccess().getLhsAssignment_1(), "rule__Expression__LhsAssignment_1");
			builder.put(grammarAccess.getExpressionAccess().getOperatorAssignment_2(), "rule__Expression__OperatorAssignment_2");
			builder.put(grammarAccess.getExpressionAccess().getRhsAssignment_3(), "rule__Expression__RhsAssignment_3");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private DslGrammarAccess grammarAccess;

	@Override
	protected InternalDslParser createParser() {
		InternalDslParser result = new InternalDslParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}

	@Override
	protected String getRuleName(AbstractElement element) {
		return nameMappings.getRuleName(element);
	}

	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}

	public DslGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(DslGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
