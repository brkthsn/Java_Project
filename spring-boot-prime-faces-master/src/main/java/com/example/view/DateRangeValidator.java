package com.example.view;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.Date;

@FacesValidator("dateRangeValidator")
public class DateRangeValidator implements Validator {
	@Override
	public void validate(FacesContext context, UIComponent uiComponent, Object o) throws ValidatorException {
		UIInput startDateInput = (UIInput) uiComponent.getAttributes().get("startDateAttr");
		Date startDate = (Date) startDateInput.getValue();
		Date endDate = (Date) o;

		if (endDate.before(startDate)) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid start/end dates.", "Start date cannot be after end date.");
			throw new ValidatorException(msg);
		}

		long difference_In_Time = endDate.getTime() - startDate.getTime();
		long difference_In_Days = (difference_In_Time / (1000 * 60 * 60 * 24)) % 365;

		if (difference_In_Days > 10) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid start/end dates.", "Date range not must be bigger than 20 day");
			throw new ValidatorException(message);
		}
	}
}