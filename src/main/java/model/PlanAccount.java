package model;

public enum PlanAccount {
	REVENUE("Revenue"),
	CHARGES("Charges"),
	TRANSFERS("Transfers");
	
	private String descricao;

	PlanAccount(String descricao) {
        this.descricao = descricao;
    }

    public String getPlanAccount() {
    	return descricao;
    }
}
