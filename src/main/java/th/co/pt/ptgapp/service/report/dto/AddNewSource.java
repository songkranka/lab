package th.co.pt.ptgapp.service.report.dto;

public class AddNewSource {

	private String source_id;
	private String source_name;
	private String codcomp;
	private String create_by;
	private String create_date;
	private String update_by;
	private String update_date;
	private String getSourceId;

	/**
	 * @return the source_id
	 */
	public String getsource_id() {
		return source_id;
	}

	/**
	 * @param source_id the source_id to set
	 */
	public void setsource_id(String source_id) {
		this.source_id = source_id;
	}

	/**
	 * @return the source_name
	 */
	public String getsource_name() {
		return source_name;
	}

	/**
	 * @param source_name the source_name to set
	 */
	public void setsource_name(String source_name) {
		this.source_name = source_name;
	}

	/**
	 * @return the codcomp
	 */
	public String getcodcomp() {
		return codcomp;
	}

	/**
	 * @param codcomp the codcomp to set
	 */
	public void setcodcomp(String codcomp) {
		this.codcomp = codcomp;
	}

	/**
	 * @return the create_by
	 */
	public String getcreate_by() {
		return create_by;
	}

	/**
	 * @param create_by the create_by to set
	 */
	public void setcreate_by(String create_by) {
		this.create_by = create_by;
	}

	/**
	 * @return the create_date
	 */
	public String getcreate_date() {
		return create_date;
	}

	/**
	 * @param create_date the create_date to set
	 */
	public void setcreate_date(String create_date) {
		this.create_date = create_date;
	}

	/**
	 * @return the update_by
	 */
	public String getupdate_by() {
		return update_by;
	}

	/**
	 * @param update_by the update_by to set
	 */
	public void setupdate_by(String update_by) {
		this.update_by = update_by;
	}

	/**
	 * @return the update_date
	 */
	public String getupdate_date() {
		return update_date;
	}

	/**
	 * @param update_date the update_date to set
	 */
	public void setupdate_date(String update_date) {
		this.update_date = update_date;
	}

	/**
	 * @return the getSourceId
	 */
	public String getGetSourceId() {
		return getSourceId;
	}

	/**
	 * @param getSourceId the getSourceId to set
	 */
	public void setGetSourceId(String getSourceId) {
		this.getSourceId = getSourceId;
	}

}
