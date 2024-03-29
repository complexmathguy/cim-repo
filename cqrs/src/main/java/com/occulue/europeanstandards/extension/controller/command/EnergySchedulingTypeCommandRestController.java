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
package com.occulue.europeanstandards.extension.controller.command;

import com.occulue.api.*;
import com.occulue.controller.*;
import com.occulue.controller.command.*;
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
 * Implements Spring Controller command CQRS processing for entity EnergySchedulingType.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/EnergySchedulingType")
public class EnergySchedulingTypeCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a EnergySchedulingType. if not key provided, calls create, otherwise calls save
   *
   * @param EnergySchedulingType energySchedulingType
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateEnergySchedulingTypeCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          EnergySchedulingTypeBusinessDelegate.getEnergySchedulingTypeInstance()
              .createEnergySchedulingType(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a EnergySchedulingType. if no key provided, calls create, otherwise calls save
   *
   * @param EnergySchedulingType energySchedulingType
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateEnergySchedulingTypeCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateEnergySchedulingTypeCommand
      // -----------------------------------------------
      completableFuture =
          EnergySchedulingTypeBusinessDelegate.getEnergySchedulingTypeInstance()
              .updateEnergySchedulingType(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "EnergySchedulingTypeController:update() - successfully update EnergySchedulingType - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a EnergySchedulingType entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(
      @RequestParam(required = true) UUID energySchedulingTypeId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteEnergySchedulingTypeCommand command =
        new DeleteEnergySchedulingTypeCommand(energySchedulingTypeId);

    try {
      EnergySchedulingTypeBusinessDelegate delegate =
          EnergySchedulingTypeBusinessDelegate.getEnergySchedulingTypeInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted EnergySchedulingType with key "
              + command.getEnergySchedulingTypeId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected EnergySchedulingType energySchedulingType = null;
  private static final Logger LOGGER =
      Logger.getLogger(EnergySchedulingTypeCommandRestController.class.getName());
}
