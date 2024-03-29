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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.loadmodel.controller.query;

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
 * Implements Spring Controller query CQRS processing for entity NonConformLoad.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/NonConformLoad")
public class NonConformLoadQueryRestController extends BaseSpringRestController {

  /**
   * Handles loading a NonConformLoad using a UUID
   *
   * @param UUID nonConformLoadId
   * @return NonConformLoad
   */
  @GetMapping("/load")
  public NonConformLoad load(@RequestParam(required = true) UUID nonConformLoadId) {
    NonConformLoad entity = null;

    try {
      entity =
          NonConformLoadBusinessDelegate.getNonConformLoadInstance()
              .getNonConformLoad(new NonConformLoadFetchOneSummary(nonConformLoadId));
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load NonConformLoad using Id " + nonConformLoadId);
      return null;
    }

    return entity;
  }

  /**
   * Handles loading all NonConformLoad business objects
   *
   * @return Set<NonConformLoad>
   */
  @GetMapping("/")
  public List<NonConformLoad> loadAll() {
    List<NonConformLoad> nonConformLoadList = null;

    try {
      // load the NonConformLoad
      nonConformLoadList =
          NonConformLoadBusinessDelegate.getNonConformLoadInstance().getAllNonConformLoad();

      if (nonConformLoadList != null)
        LOGGER.log(Level.INFO, "successfully loaded all NonConformLoads");
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load all NonConformLoads ", exc);
      return null;
    }

    return nonConformLoadList;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected NonConformLoad nonConformLoad = null;
  private static final Logger LOGGER =
      Logger.getLogger(NonConformLoadQueryRestController.class.getName());
}
