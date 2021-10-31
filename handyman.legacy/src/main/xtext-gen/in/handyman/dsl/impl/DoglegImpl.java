/**
 * generated by Xtext 2.25.0
 */
package in.handyman.dsl.impl;

import in.handyman.dsl.Dogleg;
import in.handyman.dsl.DslPackage;
import in.handyman.dsl.StartProcess;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dogleg</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link in.handyman.dsl.impl.DoglegImpl#getInheritContext <em>Inherit Context</em>}</li>
 *   <li>{@link in.handyman.dsl.impl.DoglegImpl#getProcessList <em>Process List</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DoglegImpl extends ActionImpl implements Dogleg
{
  /**
   * The default value of the '{@link #getInheritContext() <em>Inherit Context</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInheritContext()
   * @generated
   * @ordered
   */
  protected static final String INHERIT_CONTEXT_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getInheritContext() <em>Inherit Context</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInheritContext()
   * @generated
   * @ordered
   */
  protected String inheritContext = INHERIT_CONTEXT_EDEFAULT;

  /**
   * The cached value of the '{@link #getProcessList() <em>Process List</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProcessList()
   * @generated
   * @ordered
   */
  protected EList<StartProcess> processList;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DoglegImpl()
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
    return DslPackage.Literals.DOGLEG;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getInheritContext()
  {
    return inheritContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setInheritContext(String newInheritContext)
  {
    String oldInheritContext = inheritContext;
    inheritContext = newInheritContext;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.DOGLEG__INHERIT_CONTEXT, oldInheritContext, inheritContext));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<StartProcess> getProcessList()
  {
    if (processList == null)
    {
      processList = new EObjectContainmentEList<StartProcess>(StartProcess.class, this, DslPackage.DOGLEG__PROCESS_LIST);
    }
    return processList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case DslPackage.DOGLEG__PROCESS_LIST:
        return ((InternalEList<?>)getProcessList()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case DslPackage.DOGLEG__INHERIT_CONTEXT:
        return getInheritContext();
      case DslPackage.DOGLEG__PROCESS_LIST:
        return getProcessList();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case DslPackage.DOGLEG__INHERIT_CONTEXT:
        setInheritContext((String)newValue);
        return;
      case DslPackage.DOGLEG__PROCESS_LIST:
        getProcessList().clear();
        getProcessList().addAll((Collection<? extends StartProcess>)newValue);
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
      case DslPackage.DOGLEG__INHERIT_CONTEXT:
        setInheritContext(INHERIT_CONTEXT_EDEFAULT);
        return;
      case DslPackage.DOGLEG__PROCESS_LIST:
        getProcessList().clear();
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
      case DslPackage.DOGLEG__INHERIT_CONTEXT:
        return INHERIT_CONTEXT_EDEFAULT == null ? inheritContext != null : !INHERIT_CONTEXT_EDEFAULT.equals(inheritContext);
      case DslPackage.DOGLEG__PROCESS_LIST:
        return processList != null && !processList.isEmpty();
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

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (inheritContext: ");
    result.append(inheritContext);
    result.append(')');
    return result.toString();
  }

} //DoglegImpl
