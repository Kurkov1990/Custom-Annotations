package app.controller;

import app.annotations.Author;
import app.annotations.MethodInfo;
import app.model.AppModel;
import app.utils.ArrayUtils;
import app.view.AppView;

import java.lang.reflect.Method;
import java.util.Arrays;

public class AppController {

    private final AppView appView = new AppView();
    private final AppModel appModel = new AppModel();
    private final ArrayUtils arrayUtils = new ArrayUtils();

    public void runApp() {
        displayAnnotationInfo();
        processArray(appModel.createTestArray());
    }

    private void displayAnnotationInfo() {
        Class<ArrayUtils> clazz = ArrayUtils.class;
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(MethodInfo.class) && method.isAnnotationPresent(Author.class)) {
                MethodInfo methodInfo = method.getAnnotation(MethodInfo.class);
                Author author = method.getAnnotation(Author.class);

                String methodDetails = """
                        ----------------------------
                        Method Name : %s
                        Return Type : %s
                        Description : %s
                        Author      : %s %s
                        ----------------------------
                        """.formatted(
                        methodInfo.name(),
                        methodInfo.returnType(),
                        methodInfo.description(),
                        author.firstName(),
                        author.lastName()
                );
                appView.getOutput(methodDetails);
            }
        }
    }

    private void processArray(int[] array) {
        appView.getOutput(Arrays.toString(array));
        int randomNumber1 = appModel.getRandomNumber();
        int randomNumber2 = appModel.getRandomNumber();
        String results = """
                Average   : %.2f
                Min       : %d
                Max       : %d
                Sum       : %d
                Reversed  : %s
                Contains %d: %b
                Contains %d: %b
                """.formatted(
                arrayUtils.average(array),
                arrayUtils.min(array),
                arrayUtils.max(array),
                arrayUtils.sum(array),
                Arrays.toString(arrayUtils.reverse(array)),
                randomNumber1,
                arrayUtils.contains(array, randomNumber1),
                randomNumber2,
                arrayUtils.contains(array, randomNumber2)
        );
        appView.getOutput(results);
    }
}
