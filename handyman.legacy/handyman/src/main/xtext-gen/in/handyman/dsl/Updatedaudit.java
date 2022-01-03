/**
 * generated by Xtext 2.16.0
 */
package in.handyman.dsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Updatedaudit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link in.handyman.dsl.Updatedaudit#getLogsink <em>Logsink</em>}</li>
 *   <li>{@link in.handyman.dsl.Updatedaudit#getDatasource <em>Datasource</em>}</li>
 *   <li>{@link in.handyman.dsl.Updatedaudit#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see in.handyman.dsl.DslPackage#getUpdatedaudit()
 * @model
 * @generated
 */
public interface Updatedaudit extends Action
{
  /**
   * Returns the value of the '<em><b>Logsink</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Logsink</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Logsink</em>' attribute.
   * @see #setLogsink(String)
   * @see in.handyman.dsl.DslPackage#getUpdatedaudit_Logsink()
   * @model
   * @generated
   */
  String getLogsink();

  /**
   * Sets the value of the '{@link in.handyman.dsl.Updatedaudit#getLogsink <em>Logsink</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Logsink</em>' attribute.
   * @see #getLogsink()
   * @generated
   */
  void setLogsink(String value);

  /**
   * Returns the value of the '<em><b>Datasource</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Datasource</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Datasource</em>' attribute.
   * @see #setDatasource(String)
   * @see in.handyman.dsl.DslPackage#getUpdatedaudit_Datasource()
   * @model
   * @generated
   */
  String getDatasource();

  /**
   * Sets the value of the '{@link in.handyman.dsl.Updatedaudit#getDatasource <em>Datasource</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Datasource</em>' attribute.
   * @see #getDatasource()
   * @generated
   */
  void setDatasource(String value);

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
   * @see in.handyman.dsl.DslPackage#getUpdatedaudit_Value()
   * @model
   * @generated
   */
  String getValue();

  /**
   * Sets the value of the '{@link in.handyman.dsl.Updatedaudit#getValue <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' attribute.
   * @see #getValue()
   * @generated
   */
  void setValue(String value);

} // Updatedaudit
