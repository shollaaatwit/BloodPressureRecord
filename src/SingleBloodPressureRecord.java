import java.util.Objects;

public class SingleBloodPressureRecord implements BloodPressureRecord {

  private double dia;
  private double sys;
  private int id;

  public SingleBloodPressureRecord(double dia, double sys, int id) throws IllegalArgumentException {
    if(dia > sys || id < 0) {
      throw new IllegalArgumentException();
    }
    this.dia = dia;
    this.sys = sys;
    this.id = id;
  }
  @Override
  public String getID() {
    return Integer.toString(id);
  }

  @Override
  public double getSystolicReading() {
    return sys;
  }

  @Override
  public double getDiastolicReading() {
    return dia;
  }

  @Override
  public void updateSystolicReading(double sys) throws IllegalArgumentException {
    if(sys < getDiastolicReading()) {
      throw new IllegalArgumentException();
    }
    this.sys = sys;
  }

  @Override
  public void updateDiastolicReading(double dia) throws IllegalArgumentException {
    if(dia > getSystolicReading()) {
      throw new IllegalArgumentException();
    }
    this.dia = dia;
  }

  @Override
  public boolean equals(Object obj) {
    if(!(obj instanceof BloodPressureRecord)) {
      return false;
    }
    BloodPressureRecord other = (BloodPressureRecord) obj;
    if(!(this.getID().equals(other.getID()))) {
      return false;
    }
    if(!(Math.round(this.getSystolicReading())
            == Math.round(other.getSystolicReading()))) {
      return false;
    }
    if(!(Math.round(this.getDiastolicReading())
            == Math.round(other.getDiastolicReading()))) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    return (int) (id + Math.round(getSystolicReading()) + Math.round(getDiastolicReading()));
  }
}
