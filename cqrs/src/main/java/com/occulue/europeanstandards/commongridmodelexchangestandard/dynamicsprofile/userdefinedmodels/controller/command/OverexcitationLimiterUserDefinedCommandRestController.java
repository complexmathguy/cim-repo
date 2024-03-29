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
 * Implements Spring Controller command CQRS processing for entity OverexcitationLimiterUserDefined.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/OverexcitationLimiterUserDefined")
public class OverexcitationLimiterUserDefinedCommandRestController
    extends BaseSpringRestController {

  /**
   * Handles create a OverexcitationLimiterUserDefined. if not key provided, calls create, otherwise
   * calls save
   *
   * @param OverexcitationLimiterUserDefined overexcitationLimiterUserDefined
   * @return CompletableFuture<UUID>
   */
  @PostMapping("/create")
  public CompletableFuture<UUID> create(
      @RequestBody(required = true) CreateOverexcitationLimiterUserDefinedCommand command) {
    CompletableFuture<UUID> completableFuture = null;
    try {

      completableFuture =
          OverexcitationLimiterUserDefinedBusinessDelegate
              .getOverexcitationLimiterUserDefinedInstance()
              .createOverexcitationLimiterUserDefined(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage(), exc);
    }

    return completableFuture;
  }

  /**
   * Handles updating a OverexcitationLimiterUserDefined. if no key provided, calls create,
   * otherwise calls save
   *
   * @param OverexcitationLimiterUserDefined overexcitationLimiterUserDefined
   * @return CompletableFuture<Void>
   */
  @PutMapping("/update")
  public CompletableFuture<Void> update(
      @RequestBody(required = true) UpdateOverexcitationLimiterUserDefinedCommand command) {
    CompletableFuture<Void> completableFuture = null;
    try {
      // -----------------------------------------------
      // delegate the UpdateOverexcitationLimiterUserDefinedCommand
      // -----------------------------------------------
      completableFuture =
          OverexcitationLimiterUserDefinedBusinessDelegate
              .getOverexcitationLimiterUserDefinedInstance()
              .updateOverexcitationLimiterUserDefined(command);
      ;
    } catch (Throwable exc) {
      LOGGER.log(
          Level.WARNING,
          "OverexcitationLimiterUserDefinedController:update() - successfully update OverexcitationLimiterUserDefined - "
              + exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * Handles deleting a OverexcitationLimiterUserDefined entity
   *
   * @param command ${class.getDeleteCommandAlias()}
   * @return CompletableFuture<Void>
   */
  @DeleteMapping("/delete")
  public CompletableFuture<Void> delete(
      @RequestParam(required = true) UUID overexcitationLimiterUserDefinedId) {
    CompletableFuture<Void> completableFuture = null;
    DeleteOverexcitationLimiterUserDefinedCommand command =
        new DeleteOverexcitationLimiterUserDefinedCommand(overexcitationLimiterUserDefinedId);

    try {
      OverexcitationLimiterUserDefinedBusinessDelegate delegate =
          OverexcitationLimiterUserDefinedBusinessDelegate
              .getOverexcitationLimiterUserDefinedInstance();

      completableFuture = delegate.delete(command);
      LOGGER.log(
          Level.WARNING,
          "Successfully deleted OverexcitationLimiterUserDefined with key "
              + command.getOverexcitationLimiterUserDefinedId());
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, exc.getMessage());
    }

    return completableFuture;
  }

  /**
   * save Proprietary on OverexcitationLimiterUserDefined
   *
   * @param command AssignProprietaryToOverexcitationLimiterUserDefinedCommand
   */
  @PutMapping("/assignProprietary")
  public void assignProprietary(
      @RequestBody AssignProprietaryToOverexcitationLimiterUserDefinedCommand command) {
    try {
      OverexcitationLimiterUserDefinedBusinessDelegate.getOverexcitationLimiterUserDefinedInstance()
          .assignProprietary(command);
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "Failed to assign Proprietary", exc);
    }
  }

  /**
   * unassign Proprietary on OverexcitationLimiterUserDefined
   *
   * @param command UnAssignProprietaryFromOverexcitationLimiterUserDefinedCommand
   */
  @PutMapping("/unAssignProprietary")
  public void unAssignProprietary(
      @RequestBody(required = true)
          UnAssignProprietaryFromOverexcitationLimiterUserDefinedCommand command) {
    try {
      OverexcitationLimiterUserDefinedBusinessDelegate.getOverexcitationLimiterUserDefinedInstance()
          .unAssignProprietary(command);
    } catch (Exception exc) {
      LOGGER.log(Level.WARNING, "Failed to unassign Proprietary", exc);
    }
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected OverexcitationLimiterUserDefined overexcitationLimiterUserDefined = null;
  private static final Logger LOGGER =
      Logger.getLogger(OverexcitationLimiterUserDefinedCommandRestController.class.getName());
}
