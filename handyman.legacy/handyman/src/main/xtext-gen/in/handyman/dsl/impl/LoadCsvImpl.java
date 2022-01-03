/**
 * generated by Xtext 2.16.0
 */
package in.handyman.dsl.impl;

import in.handyman.dsl.DslPackage;
import in.handyman.dsl.LoadCsv;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Load Csv</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link in.handyman.dsl.impl.LoadCsvImpl#getSource <em>Source</em>}</li>
 *   <li>{@link in.handyman.dsl.impl.LoadCsvImpl#getTo <em>To</em>}</li>
 *   <li>{@link in.handyman.dsl.impl.LoadCsvImpl#getDelim <em>Delim</em>}</li>
 *   <li>{@link in.handyman.dsl.impl.LoadCsvImpl#getFetchBatchSize <em>Fetch Batch Size</em>}</li>
 *   <li>{@link in.handyman.dsl.impl.LoadCsvImpl#getWriteBatchSize <em>Write Batch Size</em>}</li>
 *   <li>{@link in.handyman.dsl.impl.LoadCsvImpl#getValue <em>Value</em>}</li>
 *   <li>{@link in.handyman.dsl.impl.LoadCsvImpl#getWriteThreadCount <em>Write Thread Count</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LoadCsvImpl extends ActionImpl implements LoadCsv
{
  /**
   * The default value of the '{@link #getSource() <em>Source</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSource()
   * @generated
   * @ordered
   */
  protected static final String SOURCE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getSource() <em>Source</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSource()
   * @generated
   * @ordered
   */
  protected String source = SOURCE_EDEFAULT;

  /**
   * The default value of the '{@link #getTo() <em>To</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTo()
   * @generated
   * @ordered
   */
  protected static final String TO_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTo() <em>To</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTo()
   * @generated
   * @ordered
   */
  protected String to = TO_EDEFAULT;

  /**
   * The default value of the '{@link #getDelim() <em>Delim</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDelim()
   * @generated
   * @ordered
   */
  protected static final String DELIM_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDelim() <em>Delim</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDelim()
   * @generated
   * @ordered
   */
  protected String delim = DELIM_EDEFAULT;

  /**
   * The default value of the '{@link #getFetchBatchSize() <em>Fetch Batch Size</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFetchBatchSize()
   * @generated
   * @ordered
   */
  protected static final int FETCH_BATCH_SIZE_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getFetchBatchSize() <em>Fetch Batch Size</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFetchBatchSize()
   * @generated
   * @ordered
   */
  protected int fetchBatchSize = FETCH_BATCH_SIZE_EDEFAULT;

  /**
   * The default value of the '{@link #getWriteBatchSize() <em>Write Batch Size</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWriteBatchSize()
   * @generated
   * @ordered
   */
  protected static final int WRITE_BATCH_SIZE_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getWriteBatchSize() <em>Write Batch Size</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWriteBatchSize()
   * @generated
   * @ordered
   */
  protected int writeBatchSize = WRITE_BATCH_SIZE_EDEFAULT;

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
   * The default value of the '{@link #getWriteThreadCount() <em>Write Thread Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWriteThreadCount()
   * @generated
   * @ordered
   */
  protected static final int WRITE_THREAD_COUNT_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getWriteThreadCount() <em>Write Thread Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWriteThreadCount()
   * @generated
   * @ordered
   */
  protected int writeThreadCount = WRITE_THREAD_COUNT_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected LoadCsvImpl()
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
    return DslPackage.Literals.LOAD_CSV;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getSource()
  {
    return source;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSource(String newSource)
  {
    String oldSource = source;
    source = newSource;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.LOAD_CSV__SOURCE, oldSource, source));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getTo()
  {
    return to;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTo(String newTo)
  {
    String oldTo = to;
    to = newTo;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.LOAD_CSV__TO, oldTo, to));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDelim()
  {
    return delim;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDelim(String newDelim)
  {
    String oldDelim = delim;
    delim = newDelim;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.LOAD_CSV__DELIM, oldDelim, delim));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getFetchBatchSize()
  {
    return fetchBatchSize;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFetchBatchSize(int newFetchBatchSize)
  {
    int oldFetchBatchSize = fetchBatchSize;
    fetchBatchSize = newFetchBatchSize;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.LOAD_CSV__FETCH_BATCH_SIZE, oldFetchBatchSize, fetchBatchSize));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getWriteBatchSize()
  {
    return writeBatchSize;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setWriteBatchSize(int newWriteBatchSize)
  {
    int oldWriteBatchSize = writeBatchSize;
    writeBatchSize = newWriteBatchSize;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.LOAD_CSV__WRITE_BATCH_SIZE, oldWriteBatchSize, writeBatchSize));
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
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.LOAD_CSV__VALUE, oldValue, value));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getWriteThreadCount()
  {
    return writeThreadCount;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setWriteThreadCount(int newWriteThreadCount)
  {
    int oldWriteThreadCount = writeThreadCount;
    writeThreadCount = newWriteThreadCount;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.LOAD_CSV__WRITE_THREAD_COUNT, oldWriteThreadCount, writeThreadCount));
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
      case DslPackage.LOAD_CSV__SOURCE:
        return getSource();
      case DslPackage.LOAD_CSV__TO:
        return getTo();
      case DslPackage.LOAD_CSV__DELIM:
        return getDelim();
      case DslPackage.LOAD_CSV__FETCH_BATCH_SIZE:
        return getFetchBatchSize();
      case DslPackage.LOAD_CSV__WRITE_BATCH_SIZE:
        return getWriteBatchSize();
      case DslPackage.LOAD_CSV__VALUE:
        return getValue();
      case DslPackage.LOAD_CSV__WRITE_THREAD_COUNT:
        return getWriteThreadCount();
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
      case DslPackage.LOAD_CSV__SOURCE:
        setSource((String)newValue);
        return;
      case DslPackage.LOAD_CSV__TO:
        setTo((String)newValue);
        return;
      case DslPackage.LOAD_CSV__DELIM:
        setDelim((String)newValue);
        return;
      case DslPackage.LOAD_CSV__FETCH_BATCH_SIZE:
        setFetchBatchSize((Integer)newValue);
        return;
      case DslPackage.LOAD_CSV__WRITE_BATCH_SIZE:
        setWriteBatchSize((Integer)newValue);
        return;
      case DslPackage.LOAD_CSV__VALUE:
        setValue((String)newValue);
        return;
      case DslPackage.LOAD_CSV__WRITE_THREAD_COUNT:
        setWriteThreadCount((Integer)newValue);
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
      case DslPackage.LOAD_CSV__SOURCE:
        setSource(SOURCE_EDEFAULT);
        return;
      case DslPackage.LOAD_CSV__TO:
        setTo(TO_EDEFAULT);
        return;
      case DslPackage.LOAD_CSV__DELIM:
        setDelim(DELIM_EDEFAULT);
        return;
      case DslPackage.LOAD_CSV__FETCH_BATCH_SIZE:
        setFetchBatchSize(FETCH_BATCH_SIZE_EDEFAULT);
        return;
      case DslPackage.LOAD_CSV__WRITE_BATCH_SIZE:
        setWriteBatchSize(WRITE_BATCH_SIZE_EDEFAULT);
        return;
      case DslPackage.LOAD_CSV__VALUE:
        setValue(VALUE_EDEFAULT);
        return;
      case DslPackage.LOAD_CSV__WRITE_THREAD_COUNT:
        setWriteThreadCount(WRITE_THREAD_COUNT_EDEFAULT);
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
      case DslPackage.LOAD_CSV__SOURCE:
        return SOURCE_EDEFAULT == null ? source != null : !SOURCE_EDEFAULT.equals(source);
      case DslPackage.LOAD_CSV__TO:
        return TO_EDEFAULT == null ? to != null : !TO_EDEFAULT.equals(to);
      case DslPackage.LOAD_CSV__DELIM:
        return DELIM_EDEFAULT == null ? delim != null : !DELIM_EDEFAULT.equals(delim);
      case DslPackage.LOAD_CSV__FETCH_BATCH_SIZE:
        return fetchBatchSize != FETCH_BATCH_SIZE_EDEFAULT;
      case DslPackage.LOAD_CSV__WRITE_BATCH_SIZE:
        return writeBatchSize != WRITE_BATCH_SIZE_EDEFAULT;
      case DslPackage.LOAD_CSV__VALUE:
        return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
      case DslPackage.LOAD_CSV__WRITE_THREAD_COUNT:
        return writeThreadCount != WRITE_THREAD_COUNT_EDEFAULT;
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
    result.append(" (source: ");
    result.append(source);
    result.append(", to: ");
    result.append(to);
    result.append(", delim: ");
    result.append(delim);
    result.append(", fetchBatchSize: ");
    result.append(fetchBatchSize);
    result.append(", writeBatchSize: ");
    result.append(writeBatchSize);
    result.append(", value: ");
    result.append(value);
    result.append(", writeThreadCount: ");
    result.append(writeThreadCount);
    result.append(')');
    return result.toString();
  }

} //LoadCsvImpl
