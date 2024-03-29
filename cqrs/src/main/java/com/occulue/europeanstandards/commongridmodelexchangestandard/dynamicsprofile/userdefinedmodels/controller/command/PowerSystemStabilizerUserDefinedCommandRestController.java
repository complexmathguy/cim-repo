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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.userdefinedmodels.controller.command;

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
 * Implements Spring Controller command CQRS processing for entity PowerSystemStabilizerUserDefined.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/PowerSystemStabilizerUserDefined")
public class PowerSystemStabilizerUserDefinedCommandRestController
    extends BaseSpringRestController {

  /**
   * Handles create a PowerSystemStabilizerUserDefined. if not key provided, calls create, otherwise
   * calls save
   *
   * @param PowerSystemStabilizerUserDefined powerSystemStabilizerUserDefined
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreatePowerSystemStabilizerUserDefinedCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          PowerSystemStabilizerUserDefinedBusinessDelegate
              .getPowerSystemStabilizerUserDefinedInstance()
              .createPowerSystemStabilizerUserDefined(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a PowerSystemStabilizerUserDefined. if no key provided, calls create,
   * otherwise calls save
   *
   * @param PowerSystemStabilizerUserDefined powerSystemStabilizerUserDefined
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdatePowerSystemStabilizerUserDefinedCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdatePowerSystemStabilizerUserDefinedCommand
      // -----------------------------------------------
      completableFuture =
          PowerSystemStabilizerUserDefinedBusinessDelegate
              .getPowerSystemStabilizerUserDefinedInstance()
              .updatePowerSystemStabilizerUserDefined(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "PowerSystemStabilizerUserDefinedController:update() - successfully update PowerSystemStabilizerUserDefined - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a PowerSystemStabilizerUserDefined entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(
      @RequestParam(required = true) UUID powerSystemStabilizerUserDefinedId) {
    CompletableFuture<Void> completableFuture = null;
    DeletePowerSystemStabilizerUserDefinedCommand command =
        new DeletePowerSystemStabilizerUserDefinedCommand(powerSystemStabilizerUserDefinedId);

    try {
      PowerSystemStabilizerUserDefinedBusinessDelegate delegate =
          PowerSystemStabilizerUserDefinedBusinessDelegate
              .getPowerSystemStabilizerUserDefinedInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted PowerSystemStabilizerUserDefined with key "
              + command.getPowerSystemStabilizerUserDefinedId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Proprietary on PowerSystemStabilizerUserDefined
   *
   * @param command AssignProprietaryToPowerSystemStabilizerUserDefinedCommand
   */
  @PutMapping("/assignProprietary")
  public void assignProprietary(
      @RequestBody AssignProprietaryToPowerSystemStabilizerUserDefinedCommand command) {
    try {
      PowerSystemStabilizerUserDefinedBusinessDelegate.getPowerSystemStabilizerUserDefinedInstance()
          .assignProprietary(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Proprietary", exc);
    }
  }

  /**
   * unassign Proprietary on PowerSystemStabilizerUserDefined
   *
   * @param command UnAssignProprietaryFromPowerSystemStabilizerUserDefinedCommand
   */
  @PutMapping("/unAssignProprietary")
  public void unAssignProprietary(
      @RequestBody(required = true)
          UnAssignProprietaryFromPowerSystemStabilizerUserDefinedCommand command) {
    try {
      PowerSystemStabilizerUserDefinedBusinessDelegate.getPowerSystemStabilizerUserDefinedInstance()
          .unAssignProprietary(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Proprietary", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected PowerSystemStabilizerUserDefined powerSystemStabilizerUserDefined = null;
  private static final Logger LOGGER =
      Logger.getLogger(PowerSystemStabilizerUserDefinedCommandRestController.class.getName());
}
