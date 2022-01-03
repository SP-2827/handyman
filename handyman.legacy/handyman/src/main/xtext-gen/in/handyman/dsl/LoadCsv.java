/**
 * generated by Xtext 2.16.0
 */
package in.handyman.dsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Load Csv</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link in.handyman.dsl.LoadCsv#getSource <em>Source</em>}</li>
 *   <li>{@link in.handyman.dsl.LoadCsv#getTo <em>To</em>}</li>
 *   <li>{@link in.handyman.dsl.LoadCsv#getDelim <em>Delim</em>}</li>
 *   <li>{@link in.handyman.dsl.LoadCsv#getFetchBatchSize <em>Fetch Batch Size</em>}</li>
 *   <li>{@link in.handyman.dsl.LoadCsv#getWriteBatchSize <em>Write Batch Size</em>}</li>
 *   <li>{@link in.handyman.dsl.LoadCsv#getValue <em>Value</em>}</li>
 *   <li>{@link in.handyman.dsl.LoadCsv#getWriteThreadCount <em>Write Thread Count</em>}</li>
 * </ul>
 *
 * @see in.handyman.dsl.DslPackage#getLoadCsv()
 * @model
 * @generated
 */
public interface LoadCsv extends Action
{
  /**
   * Returns the value of the '<em><b>Source</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Source</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Source</em>' attribute.
   * @see #setSource(String)
   * @see in.handyman.dsl.DslPackage#getLoadCsv_Source()
   * @model
   * @generated
   */
  String getSource();

  /**
   * Sets the value of the '{@link in.handyman.dsl.LoadCsv#getSource <em>Source</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Source</em>' attribute.
   * @see #getSource()
   * @generated
   */
  void setSource(String value);

  /**
   * Returns the value of the '<em><b>To</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>To</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>To</em>' attribute.
   * @see #setTo(String)
   * @see in.handyman.dsl.DslPackage#getLoadCsv_To()
   * @model
   * @generated
   */
  String getTo();

  /**
   * Sets the value of the '{@link in.handyman.dsl.LoadCsv#getTo <em>To</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>To</em>' attribute.
   * @see #getTo()
   * @generated
   */
  void setTo(String value);

  /**
   * Returns the value of the '<em><b>Delim</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Delim</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Delim</em>' attribute.
   * @see #setDelim(String)
   * @see in.handyman.dsl.DslPackage#getLoadCsv_Delim()
   * @model
   * @generated
   */
  String getDelim();

  /**
   * Sets the value of the '{@link in.handyman.dsl.LoadCsv#getDelim <em>Delim</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Delim</em>' attribute.
   * @see #getDelim()
   * @generated
   */
  void setDelim(String value);

  /**
   * Returns the value of the '<em><b>Fetch Batch Size</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Fetch Batch Size</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Fetch Batch Size</em>' attribute.
   * @see #setFetchBatchSize(int)
   * @see in.handyman.dsl.DslPackage#getLoadCsv_FetchBatchSize()
   * @model
   * @generated
   */
  int getFetchBatchSize();

  /**
   * Sets the value of the '{@link in.handyman.dsl.LoadCsv#getFetchBatchSize <em>Fetch Batch Size</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Fetch Batch Size</em>' attribute.
   * @see #getFetchBatchSize()
   * @generated
   */
  void setFetchBatchSize(int value);

  /**
   * Returns the value of the '<em><b>Write Batch Size</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Write Batch Size</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Write Batch Size</em>' attribute.
   * @see #setWriteBatchSize(int)
   * @see in.handyman.dsl.DslPackage#getLoadCsv_WriteBatchSize()
   * @model
   * @generated
   */
  int getWriteBatchSize();

  /**
   * Sets the value of the '{@link in.handyman.dsl.LoadCsv#getWriteBatchSize <em>Write Batch Size</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Write Batch Size</em>' attribute.
   * @see #getWriteBatchSize()
   * @generated
   */
  void setWriteBatchSize(int value);

  /**
   * Returns the value of the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' attribute.
   * @see #setValue(String)
   * @see in.handyman.dsl.DslPackage#getLoadCsv_Value()
   * @model
   * @generated
   */
  String getValue();

  /**
   * Sets the value of the '{@link in.handyman.dsl.LoadCsv#getValue <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' attribute.
   * @see #getValue()
   * @generated
   */
  void setValue(String value);

  /**
   * Returns the value of the '<em><b>Write Thread Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Write Thread Count</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Write Thread Count</em>' attribute.
   * @see #setWriteThreadCount(int)
   * @see in.handyman.dsl.DslPackage#getLoadCsv_WriteThreadCount()
   * @model
   * @generated
   */
  int getWriteThreadCount();

  /**
   * Sets the value of the '{@link in.handyman.dsl.LoadCsv#getWriteThreadCount <em>Write Thread Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Write Thread Count</em>' attribute.
   * @see #getWriteThreadCount()
   * @generated
   */
  void setWriteThreadCount(int value);

} // LoadCsv
