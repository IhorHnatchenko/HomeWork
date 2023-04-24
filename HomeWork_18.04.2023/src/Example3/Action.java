package Example3;

@FunctionalInterface
public interface Action {
    String action(int code, HttpCodes d);
}
