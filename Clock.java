public class Clock {
	
	private long time;
	
	public void setTime(long time){
		this.time = time;
	}
	
	public long getTime(){
		return this.time;
	}
	
	public Clock(){
		this.time = System.currentTimeMillis();
	}
	
	//modifico el método reset original para que funcione en un entorno de clase (agrego static)
	public static void reset(Clock r){
		r.time = System.currentTimeMillis();
	}
	
	//creo un método reset que funcione en un entorno de instancia
	public void reset(){
		this.setTime(System.currentTimeMillis());
	}
	
	public static Clock sinc(Clock r1, Clock r2){
		//con el código original esto no compila porque reset no era un método estático
		reset(r1); //podría no corresponder
		r2 = new Clock();
		r2.time = r1.time;
		return r2;
	}
	
	public void sinc(Clock r1){
		this.setTime(r1.getTime());
	}

	public static void main(String[] args) {
		Clock clock1 = new Clock();
		Clock clock2 = null;
		clock2 = sinc(clock1, clock2);
		System.out.println(clock1.equals(clock2));
		//en el código original no está definido un método reset que funcione a nivel de instancia
		clock2.reset();
		System.out.println(clock2.equals(clock1));
	}

}
