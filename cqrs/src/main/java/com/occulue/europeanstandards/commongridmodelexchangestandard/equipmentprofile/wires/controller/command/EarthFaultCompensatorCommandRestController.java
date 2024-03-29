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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity EarthFaultCompensator.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/EarthFaultCompensator")
public class EarthFaultCompensatorCommandRestController extends BaseSpringRestController {

  /**
   * Handles create a EarthFaultCompensator. if not key provided, calls create, otherwise calls save
   *
   * @param EarthFaultCompensator earthFaultCompensator
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateEarthFaultCompensatorCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          EarthFaultCompensatorBusinessDelegate.getEarthFaultCompensatorInstance()
              .createEarthFaultCompensator(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a EarthFaultCompensator. if no key provided, calls create, otherwise calls
   * save
   *
   * @param EarthFaultCompensator earthFaultCompensator
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateEarthFaultCompensatorCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateEarthFaultCompensatorCommand
      // -----------------------------------------------
      completableFuture =
          EarthFaultCompensatorBusinessDelegate.getEarthFaultCompensatorInstance()
              .updateEarthFaultCompensator(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "EarthFaultCompensatorController:update() - successfully update EarthFaultCompensator - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a EarthFaultCompensator entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(
      @RequestParam(required = true) UUID earthFaultCompensatorId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteEarthFaultCompensatorCommand command =
        new DeleteEarthFaultCompensatorCommand(earthFaultCompensatorId);

    try {
      EarthFaultCompensatorBusinessDelegate delegate =
          EarthFaultCompensatorBusinessDelegate.getEarthFaultCompensatorInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted EarthFaultCompensator with key "
              + command.getEarthFaultCompensatorId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save R on EarthFaultCompensator
   *
   * @param command AssignRToEarthFaultCompensatorCommand
   */
  @PutMapping("/assignR")
  public void assignR(@RequestBody AssignRToEarthFaultCompensatorCommand command) {
    try {
      EarthFaultCompensatorBusinessDelegate.getEarthFaultCompensatorInstance().assignR(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign R", exc);
    }
  }

  /**
   * unassign R on EarthFaultCompensator
   *
   * @param command UnAssignRFromEarthFaultCompensatorCommand
   */
  @PutMapping("/unAssignR")
  public void unAssignR(
      @RequestBody(required = true) UnAssignRFromEarthFaultCompensatorCommand command) {
    try {
      EarthFaultCompensatorBusinessDelegate.getEarthFaultCompensatorInstance().unAssignR(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign R", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected EarthFaultCompensator earthFaultCompensator = null;
  private static final Logger LOGGER =
      Logger.getLogger(EarthFaultCompensatorCommandRestController.class.getName());
}
