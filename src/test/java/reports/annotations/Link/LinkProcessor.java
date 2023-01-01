package reports.annotations.Link;

import org.testng.ITestResult;

import java.lang.reflect.Method;

public class LinkProcessor {
    public static String testLink(ITestResult result){
        String testInfo;
        try{
            Class<?> clazz = Class.forName(result.getInstanceName());
            Method method = clazz.getMethod(result.getMethod().getMethodName());
            Link link = method.getAnnotation(Link.class);
            if (link == null){
                testInfo = "<b>TestCase link was not added!</b>";
            }
            else {
                String name = link.name();
                String url = link.url();
                testInfo = "<b>TestCase Link: <a href=\"" + url + "\" target=\"_blank\" rel=\"noopener noreferrer\">" + name + "</a></b>";
            }
        } catch (NoSuchMethodException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return testInfo;
    }
}
