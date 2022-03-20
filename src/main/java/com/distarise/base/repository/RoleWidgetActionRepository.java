package com.distarise.base.repository;

import com.distarise.base.entity.RoleWidgetAction;
import com.distarise.base.entity.RoleWidgetActionId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleWidgetActionRepository extends CrudRepository<RoleWidgetAction, RoleWidgetActionId> {
    List<RoleWidgetAction> findAllByClientId(String clientId);
}
