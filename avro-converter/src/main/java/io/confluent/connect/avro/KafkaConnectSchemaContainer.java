package io.confluent.connect.avro;


import org.apache.kafka.connect.data.Schema;

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

        return schema.name().equals(that.schema.name()) && schema.version().equals(that.schema.version()); // to schema are identical when their name and version equal.
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
