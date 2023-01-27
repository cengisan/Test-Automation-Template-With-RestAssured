package reports.annotations.Link;

import org.testng.ITestResult;

import java.lang.reflect.Method;

public class LinkProcessor {
    public static String testLink(ITestResult result){
        String testInfo;
        try{
            Class<?> clazz = Class.forName(result.getInstanceName());
            Method method = clazz.getMethod(result.getMethod().getMethodName());
            Link classLink = clazz.getAnnotation(Link.class);
            Link methodLink = method.getAnnotation(Link.class);

            if (methodLink == null && classLink == null) {
                testInfo = "<b>TestCase link was not added!</b>";
            } else if (methodLink == null && classLink != null) {
                String name = classLink.name();
                String url = classLink.url();
                testInfo = "<b>TestCase Link: <a href=\"" + url + "\" target=\"_blank\" rel=\"noopener noreferrer\">" + name + "</a></b>";
            } else {
                String name = methodLink.name();
                String url = methodLink.url();
                testInfo = "<b>TestCase Link: <a href=\"" + url + "\" target=\"_blank\" rel=\"noopener noreferrer\">" + name + "</a></b>";
            }
        } catch (NoSuchMethodException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return testInfo;
    }
}
