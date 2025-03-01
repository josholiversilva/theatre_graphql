package josh.personal.theatre.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app")
public class Configuration {
    private LRU lru;

    public LRU getLRU() {
        return lru;
    }

    public void setLRU(LRU lru) {
        this.lru = lru;
    }

    public static class LRU {
        private int size;

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }
    }
}
