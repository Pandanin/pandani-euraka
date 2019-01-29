package pandnai.eureka;

import com.netflix.appinfo.InstanceInfo;
import lombok.extern.log4j.Log4j2;
import org.springframework.cloud.netflix.eureka.server.event.*;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author dot
 * @date 2019/1/29
 */
@Log4j2
@Component
public class EurekaStateChangeListener {
    @EventListener

    public void listen(EurekaInstanceCanceledEvent event) {
        log.warn("{},{},服务下线", event.getServerId(), event.getAppName());
    }

    @EventListener
    public void listen(EurekaInstanceRegisteredEvent event) {
        InstanceInfo instanceInfo = event.getInstanceInfo();
        log.info("{}:{},{},进行注册",instanceInfo.getIPAddr(),instanceInfo.getPort(), instanceInfo.getAppName());
    }

    @EventListener
    public void listen(EurekaInstanceRenewedEvent event) {
        log.info("{},{},服务进行续约", event.getServerId(), event.getAppName());
    }

    @EventListener
    public void listen(EurekaRegistryAvailableEvent event) {
        log.info("注册中心启动");
    }

    @EventListener
    public void listen(EurekaServerStartedEvent event) {
        log.info("Eureka Server 启动");
    }
}
