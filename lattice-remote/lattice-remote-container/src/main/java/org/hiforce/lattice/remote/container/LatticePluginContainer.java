package org.hiforce.lattice.remote.container;

import org.apache.dubbo.config.*;
import org.hifforce.lattice.model.register.BusinessSpec;
import org.hiforce.lattice.remote.client.LatticeRemoteInvoker;
import org.hiforce.lattice.remote.container.service.LatticeRemoteInvokerImpl;
import org.hiforce.lattice.runtime.Lattice;
import org.hiforce.lattice.runtime.ability.register.TemplateRegister;

/**
 * @author Rocky Yu
 * @since 2022/9/30
 */
public class LatticePluginContainer {

    private static LatticePluginContainer instance;

    private LatticePluginContainer() {

    }

    public static LatticePluginContainer getInstance() {
        if (null == instance) {
            instance = new LatticePluginContainer();
        }
        return instance;
    }

    public void start() {
        Lattice.getInstance().start();

        ApplicationConfig application = new ApplicationConfig();
        application.setName("lattice-remote-container");
        application.setId("lattice-remote-container");

        MonitorConfig monitorConfig = new MonitorConfig();
        monitorConfig.setProtocol("dubbo-registry");
        application.setMonitor(monitorConfig);

        ProtocolConfig protocol = new ProtocolConfig();
        protocol.setName("dubbo");
        protocol.setPort(-1);
        protocol.setThreads(200);

        RegistryConfig registry = new RegistryConfig();
        registry.setAddress("nacos://172.18.70.228:8848");
        registry.getMetaData().put("report.address", "nacos://172.18.70.228:8848");

//        ProviderConfig providerConfig = new ProviderConfig();
//        providerConfig.setFilter("testFilter");


        for (BusinessSpec businessSpec : TemplateRegister.getInstance().getBusinesses()) {
            ServiceConfig<LatticeRemoteInvoker> service = new ServiceConfig<>();
            service.setApplication(application);
            service.setRegistry(registry); // Use setRegistries() for multi-registry case
            service.setProtocol(protocol); // Use setProtocols() for multi-protocol case
            service.setInterface(LatticeRemoteInvoker.class);
            service.setRef(new LatticeRemoteInvokerImpl());
            service.setVersion("1.0.0");
//            service.setProvider(providerConfig);
            service.setGroup(String.format("lattice-%s", businessSpec.getCode()));
            service.export();
        }
    }
}