/**
 * ***************************************************************************** Turnstone Biologics
 * Confidential
 *
 * <p>2018 Turnstone Biologics All Rights Reserved.
 *
 * <p>This file is subject to the terms and conditions defined in file 'license.txt', which is part
 * of this source code package.
 *
 * <p>Contributors : Turnstone Biologics - General Release
 * ****************************************************************************
 */
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.subscriber;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.exception.*;
import com.occulue.subscriber.*;
import java.util.*;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.SubscriptionQueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.stereotype.Component;

/**
 * Subscriber for DCEquipmentContainer related events. .
 *
 * @author your_name_here
 */
@Component("dCEquipmentContainer-subscriber")
public class DCEquipmentContainerSubscriber extends BaseSubscriber {

  public DCEquipmentContainerSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<DCEquipmentContainer>, DCEquipmentContainer>
      dCEquipmentContainerSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllDCEquipmentContainerQuery(),
        ResponseTypes.multipleInstancesOf(DCEquipmentContainer.class),
        ResponseTypes.instanceOf(DCEquipmentContainer.class));
  }

  public SubscriptionQueryResult<DCEquipmentContainer, DCEquipmentContainer>
      dCEquipmentContainerSubscribe(@DestinationVariable UUID dCEquipmentContainerId) {
    return queryGateway.subscriptionQuery(
        new FindDCEquipmentContainerQuery(
            new LoadDCEquipmentContainerFilter(dCEquipmentContainerId)),
        ResponseTypes.instanceOf(DCEquipmentContainer.class),
        ResponseTypes.instanceOf(DCEquipmentContainer.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
