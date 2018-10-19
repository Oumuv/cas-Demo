package com.oumuv.casclient.conf;

/**
 * 描述：
 *
 * @Author 欧银锋
 * @Date 2018/10/19 10:45
 **/
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties (prefix = "cas")
public class CasAutoconfig {
    private String casServerLoginUrl;
    private String serverName;

    /**
     * 不用登录即可直接访问的URL，多个URL用,隔开
     */
    private String casPassUrl;
    private boolean renew = false;
    private boolean gateway = false;

    /**
     * ticket校验filter参数
     */
    private String casServerUrlPrefix;
    private boolean useSession = true;
    private boolean redirectAfterValidation = true;
    private boolean exceptionOnValidationFailure = false;

    /**
     * 默认登录时，跳回的URL统一为该URL
     */
    private String serviceUrl;

    /**
     * 静态资源过滤
     */
    private String resource;

    public String getCasServerLoginUrl() {
        return casServerLoginUrl;
    }

    public void setCasServerLoginUrl(String casServerLoginUrl) {
        this.casServerLoginUrl = casServerLoginUrl;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getCasPassUrl() {
        return casPassUrl;
    }

    public void setCasPassUrl(String casPassUrl) {
        this.casPassUrl = casPassUrl;
    }

    public boolean isRenew() {
        return renew;
    }

    public void setRenew(boolean renew) {
        this.renew = renew;
    }

    public boolean isGateway() {
        return gateway;
    }

    public void setGateway(boolean gateway) {
        this.gateway = gateway;
    }

    public String getCasServerUrlPrefix() {
        return casServerUrlPrefix;
    }

    public void setCasServerUrlPrefix(String casServerUrlPrefix) {
        this.casServerUrlPrefix = casServerUrlPrefix;
    }

    public boolean isUseSession() {
        return useSession;
    }

    public void setUseSession(boolean useSession) {
        this.useSession = useSession;
    }

    public boolean isRedirectAfterValidation() {
        return redirectAfterValidation;
    }

    public void setRedirectAfterValidation(boolean redirectAfterValidation) {
        this.redirectAfterValidation = redirectAfterValidation;
    }

    public boolean isExceptionOnValidationFailure() {
        return exceptionOnValidationFailure;
    }

    public void setExceptionOnValidationFailure(boolean exceptionOnValidationFailure) {
        this.exceptionOnValidationFailure = exceptionOnValidationFailure;
    }

    public String getServiceUrl() {
        return serviceUrl;
    }

    public void setServiceUrl(String serviceUrl) {
        this.serviceUrl = serviceUrl;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }
}

