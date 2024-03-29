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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.operationallimits.controller.query;

import com.occulue.api.*;
import com.occulue.controller.*;
import com.occulue.controller.query.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.exception.*;
import com.occulue.projector.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.web.bind.annotation.*;

/**
 * Implements Spring Controller query CQRS processing for entity OperationalLimit.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/OperationalLimit")
public class OperationalLimitQueryRestController extends BaseSpringRestController {

  /**
   * Handles loading a OperationalLimit using a UUID
   *
   * @param UUID operationalLimitId
   * @return OperationalLimit
   */
  @GetMapping("/load")
  public OperationalLimit load(@RequestParam(required = true) UUID operationalLimitId) {
    OperationalLimit entity = null;

    try {
      entity =
          OperationalLimitBusinessDelegate.getOperationalLimitInstance()
              .getOperationalLimit(new OperationalLimitFetchOneSummary(operationalLimitId));
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load OperationalLimit using Id " + operationalLimitId);
      return null;
    }

    return entity;
  }

  /**
   * Handles loading all OperationalLimit business objects
   *
   * @return Set<OperationalLimit>
   */
  @GetMapping("/")
  public List<OperationalLimit> loadAll() {
    List<OperationalLimit> operationalLimitList = null;

    try {
      // load the OperationalLimit
      operationalLimitList =
          OperationalLimitBusinessDelegate.getOperationalLimitInstance().getAllOperationalLimit();

      if (operationalLimitList != null)
        LOGGER.log(Level.INFO, "successfully loaded all OperationalLimits");
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load all OperationalLimits ", exc);
      return null;
    }

    return operationalLimitList;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected OperationalLimit operationalLimit = null;
  private static final Logger LOGGER =
      Logger.getLogger(OperationalLimitQueryRestController.class.getName());
}
