public interface Validator <E>{
    public default void validate(E e) throws ValidationException{}
}
