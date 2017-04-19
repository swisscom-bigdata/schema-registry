package io.confluent.connect.avro;


import org.apache.kafka.connect.data.Schema;

import java.util.Objects;

public class KafkaConnectSchemaContainer {

    private Schema schema;

    public KafkaConnectSchemaContainer(Schema schema) {
        assert (schema != null);
        this.schema = schema;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KafkaConnectSchemaContainer that = (KafkaConnectSchemaContainer) o;

        String name1 = schema.name();
        String name2 = that.schema.name();
        Integer version1 = schema.version();
        Integer version2 = that.schema.version();

        if (name1 != null && name2 != null && version1 != null && version2 != null) {
            return Objects.equals(schema.name(), that.schema.name()) &&
                    Objects.equals(schema.version(), that.schema.version()); // to schema are identical when their name and version equal.
        }

        return schema.equals(that.schema);
    }

    @Override
    public int hashCode() {
        String name = schema.name();
        Integer version = schema.version();

        int result = (name != null ? name.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);

        return result;
    }

    public Schema getSchema() {
        return schema;
    }
}
