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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.controller.query;

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
 * Implements Spring Controller query CQRS processing for entity DynamicsVersion.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/DynamicsVersion")
public class DynamicsVersionQueryRestController extends BaseSpringRestController {

  /**
   * Handles loading a DynamicsVersion using a UUID
   *
   * @param UUID dynamicsVersionId
   * @return DynamicsVersion
   */
  @GetMapping("/load")
  public DynamicsVersion load(@RequestParam(required = true) UUID dynamicsVersionId) {
    DynamicsVersion entity = null;

    try {
      entity =
          DynamicsVersionBusinessDelegate.getDynamicsVersionInstance()
              .getDynamicsVersion(new DynamicsVersionFetchOneSummary(dynamicsVersionId));
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load DynamicsVersion using Id " + dynamicsVersionId);
      return null;
    }

    return entity;
  }

  /**
   * Handles loading all DynamicsVersion business objects
   *
   * @return Set<DynamicsVersion>
   */
  @GetMapping("/")
  public List<DynamicsVersion> loadAll() {
    List<DynamicsVersion> dynamicsVersionList = null;

    try {
      // load the DynamicsVersion
      dynamicsVersionList =
          DynamicsVersionBusinessDelegate.getDynamicsVersionInstance().getAllDynamicsVersion();

      if (dynamicsVersionList != null)
        LOGGER.log(Level.INFO, "successfully loaded all DynamicsVersions");
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load all DynamicsVersions ", exc);
      return null;
    }

    return dynamicsVersionList;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected DynamicsVersion dynamicsVersion = null;
  private static final Logger LOGGER =
      Logger.getLogger(DynamicsVersionQueryRestController.class.getName());
}
