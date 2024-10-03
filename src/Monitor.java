public interface Monitor {

  public void add(BloodPressureRecord t);

  public void remove(BloodPressureRecord t);

  public int getNumberOfRecords();

  public boolean emergency();
}
