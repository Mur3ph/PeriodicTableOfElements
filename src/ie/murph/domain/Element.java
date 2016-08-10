package ie.murph.domain;

public class Element {

	private String m_atomicSymbol;
	private String m_name;
	private double m_atomicMass;
	private boolean isMetal;
	private String m_metalName;
	private String m_nonMetalName;
	private String material;
	
	public String getAtomicSymbol() 
	{
		return m_atomicSymbol;
	}
	
	public void setAtomicSymbol(String atomicSymbol) 
	{
		this.m_atomicSymbol = atomicSymbol;
	}
	
	public String getName() 
	{
		return m_name;
	}
	
	public void setName(String name) 
	{
		this.m_name = name;
	}
	
	public double getAtomicMass() 
	{
		return m_atomicMass;
	}
	
	public void setAtomicMass(double atomicMass)
	{
		this.m_atomicMass = atomicMass;
	}
	
	public boolean isMetal() 
	{
		return isMetal;
	}
	
	public void setMetal(boolean isMetal) 
	{
		this.isMetal = isMetal;
	}
	
	public String getMetalName() 
	{
		return m_metalName;
	}
	
	public void setMetalName(String metalName) 
	{
		this.m_metalName = metalName;
	}
	
	public String getNonMetalName() 
	{
		return m_nonMetalName;
	}
	
	public void setNonMetalName(String nonMetalName) 
	{
		this.m_nonMetalName = nonMetalName;
	}
	
	public String getMaterial() 
	{
		return material;
	}
	
	public void setMaterial(String material) 
	{
		this.material = material;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (isMetal ? 1231 : 1237);
		long temp;
		temp = Double.doubleToLongBits(m_atomicMass);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((m_atomicSymbol == null) ? 0 : m_atomicSymbol.hashCode());
		result = prime * result + ((m_metalName == null) ? 0 : m_metalName.hashCode());
		result = prime * result + ((m_name == null) ? 0 : m_name.hashCode());
		result = prime * result + ((m_nonMetalName == null) ? 0 : m_nonMetalName.hashCode());
		result = prime * result + ((material == null) ? 0 : material.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Element other = (Element) obj;
		if (isMetal != other.isMetal)
			return false;
		if (Double.doubleToLongBits(m_atomicMass) != Double.doubleToLongBits(other.m_atomicMass))
			return false;
		if (m_atomicSymbol == null) {
			if (other.m_atomicSymbol != null)
				return false;
		} else if (!m_atomicSymbol.equals(other.m_atomicSymbol))
			return false;
		if (m_metalName == null) {
			if (other.m_metalName != null)
				return false;
		} else if (!m_metalName.equals(other.m_metalName))
			return false;
		if (m_name == null) {
			if (other.m_name != null)
				return false;
		} else if (!m_name.equals(other.m_name))
			return false;
		if (m_nonMetalName == null) {
			if (other.m_nonMetalName != null)
				return false;
		} else if (!m_nonMetalName.equals(other.m_nonMetalName))
			return false;
		if (material == null) {
			if (other.material != null)
				return false;
		} else if (!material.equals(other.material))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Element - \n AtomicSymbol: " + m_atomicSymbol + 
						 "\n Name of Symbol: " + m_name + 
						 "\n Atomic Mass: " + m_atomicMass +  
						 "\n Is Element Metal: " + isMetal + 
						 "\n Metal Name: " + m_metalName + 
						 "\n Non Metal Name: " + m_nonMetalName + 
						 "\n Material: " + material + "]";
	}
	
	
	
// ################## File has this data in order ##################
	
//    atomic number
//    symbol
//    name
//    atomic mass in au or g/mol
//    CPK color in RRGGBB hex format
//    electronic configuration
//    electronegativity in Pauling
//    atomic radius in pm
//    ion radius in pm
//    van der Waals radius in pm
//    IE-1 in kJ/mol
//    EA in kJ/mol
//    oxidation states
//    standard state
//    bonding type
//    melting point in K
//    boiling point in K
//    density in g/mL
//    metal or nonmetal?
//    year discovered

	
}
