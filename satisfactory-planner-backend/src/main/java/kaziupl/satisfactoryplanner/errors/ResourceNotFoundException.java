package kaziupl.satisfactoryplanner.errors;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String resourceName, String id) {
        super(String.format(String.format("%s not found with id: %s", resourceName, id)));
    }
}
