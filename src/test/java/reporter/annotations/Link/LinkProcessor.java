package reporter.annotations.Link;

import org.testng.ITestResult;


import java.lang.reflect.Method;
import java.util.*;


public class LinkProcessor {

    public static String testLink(ITestResult result) {
        ArrayList<String> links = new ArrayList<>();
        String testInfo;
        String linksAdjustment;
        try {
            Class<?> clazz = Class.forName(result.getInstanceName());
            Method method = clazz.getMethod(result.getMethod().getMethodName());
            Link[] methodLinks = method.getDeclaredAnnotationsByType(Link.class);

            for (Link annotation : methodLinks) {
                String name = annotation.name();
                String url = annotation.url();
                System.out.println();
                testInfo = "<a href=\"" + url + "\" target=\"_blank\" rel=\"noopener noreferrer\">" + name + "</a>";
                links.add(testInfo);
            }
        } catch (NoSuchMethodException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        linksAdjustment = String.valueOf(links).replace("[", "").replace("]","");

        return linksAdjustment;
    }
}
