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
package com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.controller.query;

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
 * Implements Spring Controller query CQRS processing for entity Resistance.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/Resistance")
public class ResistanceQueryRestController extends BaseSpringRestController {

  /**
   * Handles loading a Resistance using a UUID
   *
   * @param UUID resistanceId
   * @return Resistance
   */
  @GetMapping("/load")
  public Resistance load(@RequestParam(required = true) UUID resistanceId) {
    Resistance entity = null;

    try {
      entity =
          ResistanceBusinessDelegate.getResistanceInstance()
              .getResistance(new ResistanceFetchOneSummary(resistanceId));
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load Resistance using Id " + resistanceId);
      return null;
    }

    return entity;
  }

  /**
   * Handles loading all Resistance business objects
   *
   * @return Set<Resistance>
   */
  @GetMapping("/")
  public List<Resistance> loadAll() {
    List<Resistance> resistanceList = null;

    try {
      // load the Resistance
      resistanceList = ResistanceBusinessDelegate.getResistanceInstance().getAllResistance();

      if (resistanceList != null) LOGGER.log(Level.INFO, "successfully loaded all Resistances");
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load all Resistances ", exc);
      return null;
    }

    return resistanceList;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected Resistance resistance = null;
  private static final Logger LOGGER =
      Logger.getLogger(ResistanceQueryRestController.class.getName());
}
