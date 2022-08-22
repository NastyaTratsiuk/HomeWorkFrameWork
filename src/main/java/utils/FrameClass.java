package utils;

public class FrameClass {

    public static void switchToFrameIndex(int indexFraime) {
        SingletonBrowserClass.initialize().switchTo().frame(indexFraime);
    }

    public static void switchToFrameName(String nameFraime) {
        SingletonBrowserClass.initialize().switchTo().frame(nameFraime);
    }

    public static void switchToParentFrame() {
        SingletonBrowserClass.initialize().switchTo().parentFrame();
    }

    public static void switchToDefaultContentFrame() {
        SingletonBrowserClass.initialize().switchTo().defaultContent();
        ;
    }
}
