import controller.TextFormatController;

public class Application {
    public static void main(String[] args){
        TextFormatController controller = new TextFormatController("D:\\projects\\text.txt", 20);
        controller.init();
    }
}
