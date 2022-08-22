package models;

public class Root {

    private int wait;
    private String url;
    private String webBrowser;

    public String getWebBrowser() {
        return webBrowser;
    }

    public String getUrl() {
        return url;
    }

    public int getWait() {
        return wait;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Root{");
        sb.append("wait=").append(wait);
        sb.append(", url='").append(url).append('\'');
        sb.append(", webBrowser='").append(webBrowser).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
