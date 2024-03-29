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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.userdefinedmodels.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.exception.*;
import com.occulue.validator.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.QueryUpdateEmitter;

/**
 * DiscontinuousExcitationControlUserDefined business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of DiscontinuousExcitationControlUserDefined related services in
 *       the case of a DiscontinuousExcitationControlUserDefined business related service failing.
 *   <li>Exposes a simpler, uniform DiscontinuousExcitationControlUserDefined interface to the
 *       business tier, making it easy for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill
 *       DiscontinuousExcitationControlUserDefined business related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class DiscontinuousExcitationControlUserDefinedBusinessDelegate
    extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public DiscontinuousExcitationControlUserDefinedBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * DiscontinuousExcitationControlUserDefined Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return DiscontinuousExcitationControlUserDefinedBusinessDelegate
   */
  public static DiscontinuousExcitationControlUserDefinedBusinessDelegate
      getDiscontinuousExcitationControlUserDefinedInstance() {
    return (new DiscontinuousExcitationControlUserDefinedBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createDiscontinuousExcitationControlUserDefined(
      CreateDiscontinuousExcitationControlUserDefinedCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getDiscontinuousExcitationControlUserDefinedId() == null)
        command.setDiscontinuousExcitationControlUserDefinedId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      DiscontinuousExcitationControlUserDefinedValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateDiscontinuousExcitationControlUserDefinedCommand - by convention the future
      // return value for a create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateDiscontinuousExcitationControlUserDefinedCommand of DiscontinuousExcitationControlUserDefined is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create DiscontinuousExcitationControlUserDefined - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateDiscontinuousExcitationControlUserDefinedCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateDiscontinuousExcitationControlUserDefined(
      UpdateDiscontinuousExcitationControlUserDefinedCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      DiscontinuousExcitationControlUserDefinedValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateDiscontinuousExcitationControlUserDefinedCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save DiscontinuousExcitationControlUserDefined - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteDiscontinuousExcitationControlUserDefinedCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(
      DeleteDiscontinuousExcitationControlUserDefinedCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      DiscontinuousExcitationControlUserDefinedValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteDiscontinuousExcitationControlUserDefinedCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete DiscontinuousExcitationControlUserDefined using Id = "
              + command.getDiscontinuousExcitationControlUserDefinedId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the DiscontinuousExcitationControlUserDefined via
   * DiscontinuousExcitationControlUserDefinedFetchOneSummary
   *
   * @param summary DiscontinuousExcitationControlUserDefinedFetchOneSummary
   * @return DiscontinuousExcitationControlUserDefinedFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public DiscontinuousExcitationControlUserDefined getDiscontinuousExcitationControlUserDefined(
      DiscontinuousExcitationControlUserDefinedFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException(
          "DiscontinuousExcitationControlUserDefinedFetchOneSummary arg cannot be null");

    DiscontinuousExcitationControlUserDefined entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      DiscontinuousExcitationControlUserDefinedValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a DiscontinuousExcitationControlUserDefined
      // --------------------------------------
      CompletableFuture<DiscontinuousExcitationControlUserDefined> futureEntity =
          queryGateway.query(
              new FindDiscontinuousExcitationControlUserDefinedQuery(
                  new LoadDiscontinuousExcitationControlUserDefinedFilter(
                      summary.getDiscontinuousExcitationControlUserDefinedId())),
              ResponseTypes.instanceOf(DiscontinuousExcitationControlUserDefined.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate DiscontinuousExcitationControlUserDefined with id "
              + summary.getDiscontinuousExcitationControlUserDefinedId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all DiscontinuousExcitationControlUserDefineds
   *
   * @return List<DiscontinuousExcitationControlUserDefined>
   * @exception ProcessingException Thrown if any problems
   */
  public List<DiscontinuousExcitationControlUserDefined>
      getAllDiscontinuousExcitationControlUserDefined() throws ProcessingException {
    List<DiscontinuousExcitationControlUserDefined> list = null;

    try {
      CompletableFuture<List<DiscontinuousExcitationControlUserDefined>> futureList =
          queryGateway.query(
              new FindAllDiscontinuousExcitationControlUserDefinedQuery(),
              ResponseTypes.multipleInstancesOf(DiscontinuousExcitationControlUserDefined.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all DiscontinuousExcitationControlUserDefined";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign Proprietary on DiscontinuousExcitationControlUserDefined
   *
   * @param command AssignProprietaryToDiscontinuousExcitationControlUserDefinedCommand
   * @exception ProcessingException
   */
  public void assignProprietary(
      AssignProprietaryToDiscontinuousExcitationControlUserDefinedCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getDiscontinuousExcitationControlUserDefinedId());

    BooleanProxyBusinessDelegate childDelegate =
        BooleanProxyBusinessDelegate.getBooleanProxyInstance();
    DiscontinuousExcitationControlUserDefinedBusinessDelegate parentDelegate =
        DiscontinuousExcitationControlUserDefinedBusinessDelegate
            .getDiscontinuousExcitationControlUserDefinedInstance();
    UUID childId = command.getAssignment().getBooleanProxyId();
    BooleanProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      DiscontinuousExcitationControlUserDefinedValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get BooleanProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Proprietary on DiscontinuousExcitationControlUserDefined
   *
   * @param command UnAssignProprietaryFromDiscontinuousExcitationControlUserDefinedCommand
   * @exception ProcessingException
   */
  public void unAssignProprietary(
      UnAssignProprietaryFromDiscontinuousExcitationControlUserDefinedCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      DiscontinuousExcitationControlUserDefinedValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg =
          "Failed to unassign Proprietary on DiscontinuousExcitationControlUserDefined";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return DiscontinuousExcitationControlUserDefined
   */
  private DiscontinuousExcitationControlUserDefined load(UUID id) throws ProcessingException {
    discontinuousExcitationControlUserDefined =
        DiscontinuousExcitationControlUserDefinedBusinessDelegate
            .getDiscontinuousExcitationControlUserDefinedInstance()
            .getDiscontinuousExcitationControlUserDefined(
                new DiscontinuousExcitationControlUserDefinedFetchOneSummary(id));
    return discontinuousExcitationControlUserDefined;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private DiscontinuousExcitationControlUserDefined discontinuousExcitationControlUserDefined =
      null;
  private static final Logger LOGGER =
      Logger.getLogger(DiscontinuousExcitationControlUserDefinedBusinessDelegate.class.getName());
}
