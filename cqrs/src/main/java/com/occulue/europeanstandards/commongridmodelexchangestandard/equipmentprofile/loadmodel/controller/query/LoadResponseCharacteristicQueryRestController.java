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
 * Implements Spring Controller query CQRS processing for entity LoadResponseCharacteristic.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/LoadResponseCharacteristic")
public class LoadResponseCharacteristicQueryRestController extends BaseSpringRestController {

  /**
   * Handles loading a LoadResponseCharacteristic using a UUID
   *
   * @param UUID loadResponseCharacteristicId
   * @return LoadResponseCharacteristic
   */
  @GetMapping("/load")
  public LoadResponseCharacteristic load(
      @RequestParam(required = true) UUID loadResponseCharacteristicId) {
    LoadResponseCharacteristic entity = null;

    try {
      entity =
          LoadResponseCharacteristicBusinessDelegate.getLoadResponseCharacteristicInstance()
              .getLoadResponseCharacteristic(
                  new LoadResponseCharacteristicFetchOneSummary(loadResponseCharacteristicId));
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "failed to load LoadResponseCharacteristic using Id " + loadResponseCharacteristicId);
      return null;
    }

    return entity;
  }

  /**
   * Handles loading all LoadResponseCharacteristic business objects
   *
   * @return Set<LoadResponseCharacteristic>
   */
  @GetMapping("/")
  public List<LoadResponseCharacteristic> loadAll() {
    List<LoadResponseCharacteristic> loadResponseCharacteristicList = null;

    try {
      // load the LoadResponseCharacteristic
      loadResponseCharacteristicList =
          LoadResponseCharacteristicBusinessDelegate.getLoadResponseCharacteristicInstance()
              .getAllLoadResponseCharacteristic();

      if (loadResponseCharacteristicList != null)
        LOGGER.log(Level.INFO, "successfully loaded all LoadResponseCharacteristics");
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load all LoadResponseCharacteristics ", exc);
      return null;
    }

    return loadResponseCharacteristicList;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected LoadResponseCharacteristic loadResponseCharacteristic = null;
  private static final Logger LOGGER =
      Logger.getLogger(LoadResponseCharacteristicQueryRestController.class.getName());
}
