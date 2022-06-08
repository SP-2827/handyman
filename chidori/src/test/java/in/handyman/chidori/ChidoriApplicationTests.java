package in.handyman.chidori;

import in.handyman.raven.lambda.access.repo.HandymanRepoImpl;
import in.handyman.raven.lambda.doa.config.SpwCommonConfig;
import org.junit.jupiter.api.Test;

import java.util.List;

class ChidoriApplicationTests {

    @Test
    void contextLoads() {
        final List<SpwCommonConfig> allCommonConfigs = new HandymanRepoImpl().findAllCommonConfigs();
        assert allCommonConfigs != null;
    }

}
