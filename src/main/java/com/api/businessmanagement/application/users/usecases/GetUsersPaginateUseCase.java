package com.api.businessmanagement.application.users.usecases;

import com.api.businessmanagement.application.users.services.GetUsersPaginateService;
import com.api.businessmanagement.infra.database.hibernate.users.models.User;

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
