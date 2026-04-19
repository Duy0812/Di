package OOP;

public class Service {
	private String serviceId;
	private String serviceName;
	private double unitPrice;

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public Service(String serviceId, String serviceName, double unitPrice) {
		this.serviceId = serviceId;
		this.serviceName = serviceName;
		this.unitPrice = unitPrice;
	}

	public void addService() {
	}

	public double calculateServiceFee() {
		return this.unitPrice;
	}

	public String getServiceName() {
		// TODO Auto-generated method stub
		return serviceName;
	}

	public int getUnitPrice() {
		// TODO Auto-generated method stub
		return (int) unitPrice;
	}

}
