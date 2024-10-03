public interface BloodPressureRecord {
  String getID();

  double getSystolicReading();

  double getDiastolicReading();

  void updateSystolicReading(double sys) throws IllegalArgumentException;

  void updateDiastolicReading(double dia) throws IllegalArgumentException;
}
