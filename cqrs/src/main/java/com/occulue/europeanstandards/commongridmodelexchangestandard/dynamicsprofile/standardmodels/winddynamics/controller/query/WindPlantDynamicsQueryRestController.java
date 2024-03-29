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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.winddynamics.controller.query;

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
 * Implements Spring Controller query CQRS processing for entity WindPlantDynamics.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/WindPlantDynamics")
public class WindPlantDynamicsQueryRestController extends BaseSpringRestController {

  /**
   * Handles loading a WindPlantDynamics using a UUID
   *
   * @param UUID windPlantDynamicsId
   * @return WindPlantDynamics
   */
  @GetMapping("/load")
  public WindPlantDynamics load(@RequestParam(required = true) UUID windPlantDynamicsId) {
    WindPlantDynamics entity = null;

    try {
      entity =
          WindPlantDynamicsBusinessDelegate.getWindPlantDynamicsInstance()
              .getWindPlantDynamics(new WindPlantDynamicsFetchOneSummary(windPlantDynamicsId));
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load WindPlantDynamics using Id " + windPlantDynamicsId);
      return null;
    }

    return entity;
  }

  /**
   * Handles loading all WindPlantDynamics business objects
   *
   * @return Set<WindPlantDynamics>
   */
  @GetMapping("/")
  public List<WindPlantDynamics> loadAll() {
    List<WindPlantDynamics> windPlantDynamicsList = null;

    try {
      // load the WindPlantDynamics
      windPlantDynamicsList =
          WindPlantDynamicsBusinessDelegate.getWindPlantDynamicsInstance()
              .getAllWindPlantDynamics();

      if (windPlantDynamicsList != null)
        LOGGER.log(Level.INFO, "successfully loaded all WindPlantDynamicss");
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load all WindPlantDynamicss ", exc);
      return null;
    }

    return windPlantDynamicsList;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected WindPlantDynamics windPlantDynamics = null;
  private static final Logger LOGGER =
      Logger.getLogger(WindPlantDynamicsQueryRestController.class.getName());
}
