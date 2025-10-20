package finos.traderx.tradeprocessor.model;

import java.io.Serializable;

public class PositionID implements Serializable {
	private Integer accountId;
	private String security;

	public PositionID() {
		// Entity
	}

	public PositionID(Integer accountId, String security) {
			this.accountId = accountId;
			this.security = security;
	}

  /** For testing purposes only */
  public Integer getAccountId() {
    return accountId;
  }

  /** For testing purposes only */
  public String getSecurity() {
    return security;
  }
}
