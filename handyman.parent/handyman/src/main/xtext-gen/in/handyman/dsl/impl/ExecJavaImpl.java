/**
 * generated by Xtext 2.16.0
 */
package in.handyman.dsl.impl;

import in.handyman.dsl.DslPackage;
import in.handyman.dsl.ExecJava;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Exec Java</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link in.handyman.dsl.impl.ExecJavaImpl#getClassFqn <em>Class Fqn</em>}</li>
 *   <li>{@link in.handyman.dsl.impl.ExecJavaImpl#getDbSrc <em>Db Src</em>}</li>
 *   <li>{@link in.handyman.dsl.impl.ExecJavaImpl#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ExecJavaImpl extends ActionImpl implements ExecJava
{
  /**
   * The default value of the '{@link #getClassFqn() <em>Class Fqn</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getClassFqn()
   * @generated
   * @ordered
   */
  protected static final String CLASS_FQN_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getClassFqn() <em>Class Fqn</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getClassFqn()
   * @generated
   * @ordered
   */
  protected String classFqn = CLASS_FQN_EDEFAULT;

  /**
   * The default value of the '{@link #getDbSrc() <em>Db Src</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDbSrc()
   * @generated
   * @ordered
   */
  protected static final String DB_SRC_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDbSrc() <em>Db Src</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDbSrc()
   * @generated
   * @ordered
   */
  protected String dbSrc = DB_SRC_EDEFAULT;

  /**
   * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected static final String VALUE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected String value = VALUE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ExecJavaImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return DslPackage.Literals.EXEC_JAVA;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getClassFqn()
  {
    return classFqn;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setClassFqn(String newClassFqn)
  {
    String oldClassFqn = classFqn;
    classFqn = newClassFqn;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.EXEC_JAVA__CLASS_FQN, oldClassFqn, classFqn));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDbSrc()
  {
    return dbSrc;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDbSrc(String newDbSrc)
  {
    String oldDbSrc = dbSrc;
    dbSrc = newDbSrc;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.EXEC_JAVA__DB_SRC, oldDbSrc, dbSrc));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setValue(String newValue)
  {
    String oldValue = value;
    value = newValue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.EXEC_JAVA__VALUE, oldValue, value));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case DslPackage.EXEC_JAVA__CLASS_FQN:
        return getClassFqn();
      case DslPackage.EXEC_JAVA__DB_SRC:
        return getDbSrc();
      case DslPackage.EXEC_JAVA__VALUE:
        return getValue();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case DslPackage.EXEC_JAVA__CLASS_FQN:
        setClassFqn((String)newValue);
        return;
      case DslPackage.EXEC_JAVA__DB_SRC:
        setDbSrc((String)newValue);
        return;
      case DslPackage.EXEC_JAVA__VALUE:
        setValue((String)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case DslPackage.EXEC_JAVA__CLASS_FQN:
        setClassFqn(CLASS_FQN_EDEFAULT);
        return;
      case DslPackage.EXEC_JAVA__DB_SRC:
        setDbSrc(DB_SRC_EDEFAULT);
        return;
      case DslPackage.EXEC_JAVA__VALUE:
        setValue(VALUE_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case DslPackage.EXEC_JAVA__CLASS_FQN:
        return CLASS_FQN_EDEFAULT == null ? classFqn != null : !CLASS_FQN_EDEFAULT.equals(classFqn);
      case DslPackage.EXEC_JAVA__DB_SRC:
        return DB_SRC_EDEFAULT == null ? dbSrc != null : !DB_SRC_EDEFAULT.equals(dbSrc);
      case DslPackage.EXEC_JAVA__VALUE:
        return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (classFqn: ");
    result.append(classFqn);
    result.append(", dbSrc: ");
    result.append(dbSrc);
    result.append(", value: ");
    result.append(value);
    result.append(')');
    return result.toString();
  }

} //ExecJavaImpl
