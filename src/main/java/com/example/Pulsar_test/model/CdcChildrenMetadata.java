/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.example.Pulsar_test.model;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

/** CQL UDT type */
@org.apache.avro.specific.AvroGenerated
public class CdcChildrenMetadata extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 1291506027008740100L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"CdcChildrenMetadata\",\"namespace\":\"com.example.Pulsar_test.model\",\"doc\":\"CQL UDT type\",\"fields\":[{\"name\":\"service_information\",\"type\":[\"null\",{\"type\":\"array\",\"items\":[\"null\",{\"type\":\"record\",\"name\":\"CdcServiceInformation\",\"doc\":\"CQL UDT type\",\"fields\":[{\"name\":\"service_level\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"parcel_count\",\"type\":[\"null\",\"int\"],\"default\":null}]}]}],\"default\":null}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<CdcChildrenMetadata> ENCODER =
      new BinaryMessageEncoder<CdcChildrenMetadata>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<CdcChildrenMetadata> DECODER =
      new BinaryMessageDecoder<CdcChildrenMetadata>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<CdcChildrenMetadata> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<CdcChildrenMetadata> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<CdcChildrenMetadata> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<CdcChildrenMetadata>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this CdcChildrenMetadata to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a CdcChildrenMetadata from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a CdcChildrenMetadata instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static CdcChildrenMetadata fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public java.util.List<com.example.Pulsar_test.model.CdcServiceInformation> service_information;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public CdcChildrenMetadata() {}

  /**
   * All-args constructor.
   * @param service_information The new value for service_information
   */
  public CdcChildrenMetadata(java.util.List<com.example.Pulsar_test.model.CdcServiceInformation> service_information) {
    this.service_information = service_information;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return service_information;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: service_information = (java.util.List<com.example.Pulsar_test.model.CdcServiceInformation>)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'service_information' field.
   * @return The value of the 'service_information' field.
   */
  public java.util.List<com.example.Pulsar_test.model.CdcServiceInformation> getServiceInformation() {
    return service_information;
  }


  /**
   * Sets the value of the 'service_information' field.
   * @param value the value to set.
   */
  public void setServiceInformation(java.util.List<com.example.Pulsar_test.model.CdcServiceInformation> value) {
    this.service_information = value;
  }

  /**
   * Creates a new CdcChildrenMetadata RecordBuilder.
   * @return A new CdcChildrenMetadata RecordBuilder
   */
  public static com.example.Pulsar_test.model.CdcChildrenMetadata.Builder newBuilder() {
    return new com.example.Pulsar_test.model.CdcChildrenMetadata.Builder();
  }

  /**
   * Creates a new CdcChildrenMetadata RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new CdcChildrenMetadata RecordBuilder
   */
  public static com.example.Pulsar_test.model.CdcChildrenMetadata.Builder newBuilder(com.example.Pulsar_test.model.CdcChildrenMetadata.Builder other) {
    if (other == null) {
      return new com.example.Pulsar_test.model.CdcChildrenMetadata.Builder();
    } else {
      return new com.example.Pulsar_test.model.CdcChildrenMetadata.Builder(other);
    }
  }

  /**
   * Creates a new CdcChildrenMetadata RecordBuilder by copying an existing CdcChildrenMetadata instance.
   * @param other The existing instance to copy.
   * @return A new CdcChildrenMetadata RecordBuilder
   */
  public static com.example.Pulsar_test.model.CdcChildrenMetadata.Builder newBuilder(com.example.Pulsar_test.model.CdcChildrenMetadata other) {
    if (other == null) {
      return new com.example.Pulsar_test.model.CdcChildrenMetadata.Builder();
    } else {
      return new com.example.Pulsar_test.model.CdcChildrenMetadata.Builder(other);
    }
  }

  /**
   * RecordBuilder for CdcChildrenMetadata instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<CdcChildrenMetadata>
    implements org.apache.avro.data.RecordBuilder<CdcChildrenMetadata> {

    private java.util.List<com.example.Pulsar_test.model.CdcServiceInformation> service_information;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.example.Pulsar_test.model.CdcChildrenMetadata.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.service_information)) {
        this.service_information = data().deepCopy(fields()[0].schema(), other.service_information);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
    }

    /**
     * Creates a Builder by copying an existing CdcChildrenMetadata instance
     * @param other The existing instance to copy.
     */
    private Builder(com.example.Pulsar_test.model.CdcChildrenMetadata other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.service_information)) {
        this.service_information = data().deepCopy(fields()[0].schema(), other.service_information);
        fieldSetFlags()[0] = true;
      }
    }

    /**
      * Gets the value of the 'service_information' field.
      * @return The value.
      */
    public java.util.List<com.example.Pulsar_test.model.CdcServiceInformation> getServiceInformation() {
      return service_information;
    }


    /**
      * Sets the value of the 'service_information' field.
      * @param value The value of 'service_information'.
      * @return This builder.
      */
    public com.example.Pulsar_test.model.CdcChildrenMetadata.Builder setServiceInformation(java.util.List<com.example.Pulsar_test.model.CdcServiceInformation> value) {
      validate(fields()[0], value);
      this.service_information = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'service_information' field has been set.
      * @return True if the 'service_information' field has been set, false otherwise.
      */
    public boolean hasServiceInformation() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'service_information' field.
      * @return This builder.
      */
    public com.example.Pulsar_test.model.CdcChildrenMetadata.Builder clearServiceInformation() {
      service_information = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public CdcChildrenMetadata build() {
      try {
        CdcChildrenMetadata record = new CdcChildrenMetadata();
        record.service_information = fieldSetFlags()[0] ? this.service_information : (java.util.List<com.example.Pulsar_test.model.CdcServiceInformation>) defaultValue(fields()[0]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<CdcChildrenMetadata>
    WRITER$ = (org.apache.avro.io.DatumWriter<CdcChildrenMetadata>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<CdcChildrenMetadata>
    READER$ = (org.apache.avro.io.DatumReader<CdcChildrenMetadata>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    if (this.service_information == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      long size0 = this.service_information.size();
      out.writeArrayStart();
      out.setItemCount(size0);
      long actualSize0 = 0;
      for (com.example.Pulsar_test.model.CdcServiceInformation e0: this.service_information) {
        actualSize0++;
        out.startItem();
        if (e0 == null) {
          out.writeIndex(0);
          out.writeNull();
        } else {
          out.writeIndex(1);
          e0.customEncode(out);
        }
      }
      out.writeArrayEnd();
      if (actualSize0 != size0)
        throw new java.util.ConcurrentModificationException("Array-size written was " + size0 + ", but element count was " + actualSize0 + ".");
    }

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      if (in.readIndex() != 1) {
        in.readNull();
        this.service_information = null;
      } else {
        long size0 = in.readArrayStart();
        java.util.List<com.example.Pulsar_test.model.CdcServiceInformation> a0 = this.service_information;
        if (a0 == null) {
          a0 = new SpecificData.Array<com.example.Pulsar_test.model.CdcServiceInformation>((int)size0, SCHEMA$.getField("service_information").schema().getTypes().get(1));
          this.service_information = a0;
        } else a0.clear();
        SpecificData.Array<com.example.Pulsar_test.model.CdcServiceInformation> ga0 = (a0 instanceof SpecificData.Array ? (SpecificData.Array<com.example.Pulsar_test.model.CdcServiceInformation>)a0 : null);
        for ( ; 0 < size0; size0 = in.arrayNext()) {
          for ( ; size0 != 0; size0--) {
            com.example.Pulsar_test.model.CdcServiceInformation e0 = (ga0 != null ? ga0.peek() : null);
            if (in.readIndex() != 1) {
              in.readNull();
              e0 = null;
            } else {
              if (e0 == null) {
                e0 = new com.example.Pulsar_test.model.CdcServiceInformation();
              }
              e0.customDecode(in);
            }
            a0.add(e0);
          }
        }
      }

    } else {
      for (int i = 0; i < 1; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          if (in.readIndex() != 1) {
            in.readNull();
            this.service_information = null;
          } else {
            long size0 = in.readArrayStart();
            java.util.List<com.example.Pulsar_test.model.CdcServiceInformation> a0 = this.service_information;
            if (a0 == null) {
              a0 = new SpecificData.Array<com.example.Pulsar_test.model.CdcServiceInformation>((int)size0, SCHEMA$.getField("service_information").schema().getTypes().get(1));
              this.service_information = a0;
            } else a0.clear();
            SpecificData.Array<com.example.Pulsar_test.model.CdcServiceInformation> ga0 = (a0 instanceof SpecificData.Array ? (SpecificData.Array<com.example.Pulsar_test.model.CdcServiceInformation>)a0 : null);
            for ( ; 0 < size0; size0 = in.arrayNext()) {
              for ( ; size0 != 0; size0--) {
                com.example.Pulsar_test.model.CdcServiceInformation e0 = (ga0 != null ? ga0.peek() : null);
                if (in.readIndex() != 1) {
                  in.readNull();
                  e0 = null;
                } else {
                  if (e0 == null) {
                    e0 = new com.example.Pulsar_test.model.CdcServiceInformation();
                  }
                  e0.customDecode(in);
                }
                a0.add(e0);
              }
            }
          }
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










