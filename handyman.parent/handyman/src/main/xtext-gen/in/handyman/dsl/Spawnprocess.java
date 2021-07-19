/**
 * generated by Xtext 2.16.0
 */
package in.handyman.dsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Spawnprocess</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link in.handyman.dsl.Spawnprocess#getTarget <em>Target</em>}</li>
 *   <li>{@link in.handyman.dsl.Spawnprocess#getSource <em>Source</em>}</li>
 * </ul>
 *
 * @see in.handyman.dsl.DslPackage#getSpawnprocess()
 * @model
 * @generated
 */
public interface Spawnprocess extends Action
{
  /**
   * Returns the value of the '<em><b>Target</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Target</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target</em>' attribute.
   * @see #setTarget(String)
   * @see in.handyman.dsl.DslPackage#getSpawnprocess_Target()
   * @model
   * @generated
   */
  String getTarget();

  /**
   * Sets the value of the '{@link in.handyman.dsl.Spawnprocess#getTarget <em>Target</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target</em>' attribute.
   * @see #getTarget()
   * @generated
   */
  void setTarget(String value);

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
   * @see in.handyman.dsl.DslPackage#getSpawnprocess_Source()
   * @model
   * @generated
   */
  String getSource();

  /**
   * Sets the value of the '{@link in.handyman.dsl.Spawnprocess#getSource <em>Source</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Source</em>' attribute.
   * @see #getSource()
   * @generated
   */
  void setSource(String value);

} // Spawnprocess
