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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.turbinegovernordynamics.controller.query;

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
 * Implements Spring Controller query CQRS processing for entity GovHydroIEEE0.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/GovHydroIEEE0")
public class GovHydroIEEE0QueryRestController extends BaseSpringRestController {

  /**
   * Handles loading a GovHydroIEEE0 using a UUID
   *
   * @param UUID govHydroIEEE0Id
   * @return GovHydroIEEE0
   */
  @GetMapping("/load")
  public GovHydroIEEE0 load(@RequestParam(required = true) UUID govHydroIEEE0Id) {
    GovHydroIEEE0 entity = null;

    try {
      entity =
          GovHydroIEEE0BusinessDelegate.getGovHydroIEEE0Instance()
              .getGovHydroIEEE0(new GovHydroIEEE0FetchOneSummary(govHydroIEEE0Id));
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load GovHydroIEEE0 using Id " + govHydroIEEE0Id);
      return null;
    }

    return entity;
  }

  /**
   * Handles loading all GovHydroIEEE0 business objects
   *
   * @return Set<GovHydroIEEE0>
   */
  @GetMapping("/")
  public List<GovHydroIEEE0> loadAll() {
    List<GovHydroIEEE0> govHydroIEEE0List = null;

    try {
      // load the GovHydroIEEE0
      govHydroIEEE0List =
          GovHydroIEEE0BusinessDelegate.getGovHydroIEEE0Instance().getAllGovHydroIEEE0();

      if (govHydroIEEE0List != null)
        LOGGER.log(Level.INFO, "successfully loaded all GovHydroIEEE0s");
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load all GovHydroIEEE0s ", exc);
      return null;
    }

    return govHydroIEEE0List;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected GovHydroIEEE0 govHydroIEEE0 = null;
  private static final Logger LOGGER =
      Logger.getLogger(GovHydroIEEE0QueryRestController.class.getName());
}
