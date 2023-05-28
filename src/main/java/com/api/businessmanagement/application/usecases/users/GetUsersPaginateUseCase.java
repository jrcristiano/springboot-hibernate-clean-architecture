package com.api.businessmanagement.application.usecases.users;

import com.api.businessmanagement.application.services.users.GetUsersPaginateService;
import com.api.businessmanagement.infra.orm.jpa.entities.User;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component()
public class GetUsersPaginateUseCase {
	private GetUsersPaginateService getUsersPaginateService;

	public GetUsersPaginateUseCase(GetUsersPaginateService getUsersPaginateService) {
		this.getUsersPaginateService = getUsersPaginateService;
	}

	public Page<User> execute(String page, String limit, String orderBy, String sortBy) {
		return this.getUsersPaginateService.execute(page, limit, orderBy, sortBy);
	}
}
