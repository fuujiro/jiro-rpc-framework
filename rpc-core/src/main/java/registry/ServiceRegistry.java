package registry;

/**
 * Created by fzy at 17:16 on 2020/10/18.
 */
public interface ServiceRegistry {

    <T> void register(T service);
    Object getService(String serviceName);

}
