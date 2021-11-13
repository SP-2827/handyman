package in.handyman.raven.actor;

import akka.actor.AbstractActor;
import in.handyman.raven.lambda.access.repo.HandymanRepo;
import in.handyman.raven.lambda.access.repo.HandymanRepoR2Impl;
import in.handyman.raven.lambda.doa.Action;
import in.handyman.raven.lambda.doa.ActionExecutionAudit;
import in.handyman.raven.lambda.doa.LambdaExecutionAudit;
import in.handyman.raven.lambda.doa.Pipeline;
import in.handyman.raven.lambda.doa.Statement;

public class AuditInsertActor extends AbstractActor {

    private final HandymanRepo handymanRepo = new HandymanRepoR2Impl();

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(Pipeline.class, handymanRepo::insertPipeline)
                .match(Action.class, handymanRepo::insertAction)
                .match(Statement.class, handymanRepo::insertStatement)
                .match(LambdaExecutionAudit.class, handymanRepo::insert)
                .match(ActionExecutionAudit.class, handymanRepo::insert)
                .build();
    }
}
